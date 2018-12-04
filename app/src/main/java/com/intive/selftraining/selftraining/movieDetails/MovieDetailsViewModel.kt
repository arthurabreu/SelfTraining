package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SchedulerMovieDetails {

    fun io() = Schedulers.io()

    fun ui() = AndroidSchedulers.mainThread()
}

class MovieDetailsViewModel(private val repo: MovieRepository) : ViewModel(), LifecycleObserver {

    val movieId = MutableLiveData<Int>()
    val movie = MutableLiveData<MovieDetails>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        movieId.observeForever {
            it?.let { movieId ->
                getMovieDetails(movieId)
            }
        }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    private fun getMovieDetails(id: Int) {
        compositeDisposable.add(repo.getMovieDetails(id).subscribe({
            movie.value = it
            Log.d("MOVIE DETAILS", it.toString())
        }, { error -> Log.e("MOVIE DETAILS ERROR", error.message) }))
    }
}
