package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.data.mapNetworkErrors
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.CustomScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class MovieDetailsViewModel(private val repo: MovieRepository, private val customScheduler: CustomScheduler) :
    ViewModel(), LifecycleObserver {

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
        compositeDisposable += repo.getMovieDetails(id)
            .subscribeOn(customScheduler.io())
            .observeOn(customScheduler.ui()).mapNetworkErrors()
            .subscribe({
                movie.value = it
                Log.d("LOG MOVIE DETAILS", it.toString())
            }, { error -> Log.e("LOG MOVIE DETAILS ERROR", error.message) })
    }
}
