package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables

class ListMoviesViewModel(private val repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<ZipListMovies> = MutableLiveData()

    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable?.dispose()
        super.onCleared()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
    }

    private fun getMoviesResponse() {
        val res = Observables.zip(repo.showMovies(), repo.getConfiguration()) {
            s, n ->
            ZipListMovies(s, n)
        }
        compositeDisposable?.add(res.subscribe({
            resultsList.value = it
            Log.d("RESULT_MOVIES", it.moviesResponse.results.toString())
            Log.d("CONFIGURATION", it.configuration.toString())
        }, { error -> Log.e("ERROR", error.message) }))
    }
}