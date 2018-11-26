package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsViewModel(private val repo: MovieRepository) : ViewModel(), LifecycleObserver {

    var movie: MutableLiveData<MovieDetails> = MutableLiveData()
//    val movie: MutableLiveData<String> = MutableLiveData()

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
            movie.value = it
            Log.d("MOVIE MAPPER", it.toString())
        }, { error -> Log.e("MOVIE ERROR", error.message) }))
    }
}
