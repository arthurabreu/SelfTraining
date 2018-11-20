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
        //var posterPath = resultsList.value?.get(0)?.poster_path
        //TODO another endpoint
        compositeDisposable?.add(configObservable.subscribe(
            { result ->
                //Log.i("RESULT", result)
                configuration.let { it.value = result }
            },
            { error -> Log.e("ERROR", error.message) }))

        val baseUrl = configuration.value?.images?.base_url
        val logoSize = configuration.value?.images?.logo_sizes
        val url = baseUrl + logoSize
        val completeUrl = url + resultsList.value?.get(0)?.poster_path


    }
}