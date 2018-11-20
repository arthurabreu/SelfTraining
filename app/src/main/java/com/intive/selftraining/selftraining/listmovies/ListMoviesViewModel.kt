package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<List<Result>> = MutableLiveData()
    var configuration: MutableLiveData<Configuration> = MutableLiveData()

    private var observable: Observable<MoviesResponse> = repo.showMovies()
    private var configObservable: Observable<Configuration> = repo.getConfiguration()

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable?.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
        getImageUrl()
    }

    fun getMoviesResponse() {
        compositeDisposable?.add(observable.subscribe(
            { result ->
                Log.i("RESULT", result.results.toString())
                resultsList.let { it.value = result.results }
            },
            { error -> Log.e("ERROR", error.message) }))
    }

    private fun getImageUrl() {

        compositeDisposable?.add(configObservable.subscribe(
            { result ->
                Log.i("CONFIGURATION", result.toString())
                configuration.let { it.value = result }
            },
            { error -> Log.e("CONFIGURATION", error.message) }))
    }
}