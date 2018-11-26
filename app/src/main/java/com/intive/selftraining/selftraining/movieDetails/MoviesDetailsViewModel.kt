package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import io.reactivex.disposables.CompositeDisposable

class MoviesDetailsViewModel(private val repo: MovieRepository) : ViewModel(), LifecycleObserver {

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
        compositeDisposable.add(repo.getMovieResult().subscribe({
//            resultsList.value = it
            Log.d("LIST MOVIES MAPPER", it.toString())
        }, { error -> Log.e("LIST MOVIES ERROR", error.message) }))
    }
}