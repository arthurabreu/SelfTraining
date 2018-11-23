package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.Observables

class ListMoviesViewModel(private val repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    var resultsList: MutableLiveData<ListMoviesMapper> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    private fun getMoviesResponse() {
        val res = Observables.zip(repo.showMovies(), repo.getConfiguration()) {
            movies, configuration ->
            var listMoviesMapper: ListMoviesMapper
            listMoviesMapper.fromApi(movies.apiResults, configuration)
        }
        compositeDisposable.add(res.subscribe({
            resultsList.value = it
            Log.d("RESULT_MOVIES", it.apiMoviesResponse.apiResults.toString())
            Log.d("CONFIGURATION", it.configuration.toString())
        }, { error -> Log.e("ERROR", error.message) }))
    }
}