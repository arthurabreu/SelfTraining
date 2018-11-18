package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<List<Result>>? = MutableLiveData()

    private var observable: Observable<MoviesResponse> = repo.showMovies()
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCleared() {
        compositeDisposable?.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        getMoviesResponse()
    }

    fun getMoviesResponse(): MoviesResponse? {
        var results: MoviesResponse? = null
        val disposable = observable.subscribe(
            { result ->
                Log.i("RESULT", result.results.toString())
                results = result
                resultsList?.let { it.value = result.results }
            },
            { error -> Log.e("ERROR", error.message) })
        compositeDisposable?.add(disposable)

        return results
    }
}