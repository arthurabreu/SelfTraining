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
import io.reactivex.disposables.Disposable

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<List<Result>>? = MutableLiveData()

    private var observable: Observable<MoviesResponse> = repo.showMovies()
    private var disposable: Disposable? = null

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate(){
        disposable = observable.subscribe(
            { result ->
                Log.d("RESULT", result.results.toString())
                resultsList?.let { it.value = result.results } },
            { error -> Log.e("ERROR", error.message) })
    }
}