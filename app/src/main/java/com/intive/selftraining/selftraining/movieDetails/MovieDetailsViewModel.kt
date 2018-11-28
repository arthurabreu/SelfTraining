package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsViewModel(private val repo: MovieRepository) : ViewModel(), LifecycleObserver {

    var movie: MutableLiveData<MovieDetails> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getMovieDetails(id: Int) {
        compositeDisposable.add(repo.getMovieDetails(id).subscribe({
            movie.value = it
            Log.d("MOVIE DETAILS", it.toString())
        }, { error -> Log.e("MOVIE DETAILS ERROR", error.message) }))
    }
}
