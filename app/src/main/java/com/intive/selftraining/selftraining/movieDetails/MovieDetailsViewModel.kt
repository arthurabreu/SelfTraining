package com.intive.selftraining.selftraining.movieDetails

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.intive.selftraining.selftraining.utils.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class MovieDetailsViewModel(
    private val repo: MovieRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) :
    ViewModel(), LifecycleObserver {

    val movieId = MutableLiveData<Int>()
    val movie = MutableLiveData<MovieDetails>()
    val progressBarVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

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
        progressBarVisibility.value = View.VISIBLE
        compositeDisposable += repo.getMovieDetails(id)
            .subscribeOn(customScheduler.io())
            .observeOn(customScheduler.ui())
            .subscribe({
                movie.value = it
                progressBarVisibility.value = View.GONE
                Logger.d("LOG MOVIE DETAILS", it.toString())
            },
                { error ->
                    error.message?.let {
                        Logger.e("LOG MOVIE DETAILS ERROR", it)
                        errorHandler.showError(it)
                    }
                })
    }
}
