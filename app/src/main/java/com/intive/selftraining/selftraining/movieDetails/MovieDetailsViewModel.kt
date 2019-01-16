package com.intive.selftraining.selftraining.movieDetails

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.intive.selftraining.selftraining.utils.mvvm.RxViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import timber.log.Timber

class MovieDetailsViewModel(
    private val repo: MovieRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) :
    RxViewModel(), LifecycleObserver {

    val movieId = MutableLiveData<Int>()
    val movie = MutableLiveData<MovieDetails>()
    val progressBarVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        movieId.observeForever {
            it?.let { movieId ->
                getMovieDetails(movieId)
//                readSavedMovieBy(movieId)
//                getMovieVideos(movieId)
            }
        }
    }

    private fun getMovieDetails(id: Int) {
        progressBarVisibility.value = View.VISIBLE
        launch {
            repo.getMovieDetails(id)
                .subscribeOn(customScheduler.io())
                .observeOn(customScheduler.ui())
                .subscribe({
                    movie.value = it
                    progressBarVisibility.value = View.GONE
                    Timber.d("From internet:%s", it.toString())
                },
                    { error ->
                        error.message?.let {
                            Timber.e(it)
                            errorHandler.showError(it)
                        }
                    })
        }
    }

//    private fun getMovieVideos(id: Int) {
//        launch {
//            repo.getMovieVideos(id)
//                .subscribeOn(customScheduler.io())
//                .observeOn(customScheduler.ui())
//                .subscribe({
//                    movieVideo.value = it[0]
//                    Timber.d("Movie Video:%s", it.toString())
//                },
//                    { error ->
//                        error.message?.let {
//                            Timber.e(it)
//                            errorHandler.showError(it)
//                        }
//                    })
//        }
//    }

//    fun saveMovies(movieDetails: MovieDetails) {
//        uiScope.launch {
//            Timber.d("SAVE in db:%s", movieDetails.title)
//            repo.addMovieToDB(movieDetails)
//        }
//    }
//
//    private fun readSavedMovieBy(movieId: Int) {
//        launch {
//            repo.readMovie(movieId).subscribeOn(customScheduler.io())
//                .observeOn(customScheduler.ui()).subscribe({
//                    movie.value = it
//                    Timber.d("From db:%s", it.title)
//                },
//                    { error ->
//                        error.message?.let {
//                            Timber.e(it)
//                            getMovieDetails(movieId)
//                        }
//                    })
//        }
//    }

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
