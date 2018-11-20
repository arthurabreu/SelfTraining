package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.network.models.Result
import io.reactivex.disposables.CompositeDisposable

class ListMoviesViewModel(private val repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<List<Result>> = MutableLiveData()

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
    }

    fun getMoviesResponse() {
        val disposable = repo.showMovies().subscribe(
            { result ->
                Log.i("RESULT", result.results.toString())
                resultsList.value = result.results
            },
            { error -> Log.e("ERROR", error.message) })
        compositeDisposable.add(disposable)
    }
}