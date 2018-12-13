package com.intive.selftraining.selftraining.listmovies

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.intive.selftraining.selftraining.utils.Logger
import com.intive.selftraining.selftraining.utils.mvvm.RxViewModel

class ListMoviesViewModel(
    private val repo: ListMoviesRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) :
    RxViewModel(), LifecycleObserver {

    val resultsList: MutableLiveData<List<Movie>> = MutableLiveData()
    val progressBarVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
    }

    private fun getMoviesResponse() {
        showProgressBar()

        launch {
            repo.getMovies()
                .subscribeOn(customScheduler.io())
                .observeOn(customScheduler.ui())
                .subscribe({
                    Logger.d("LOG LIST MOVIES MAPPER", it.toString())
                    resultsList.value = it
                    hideProgressBar()
                }, { error ->
                    error.message?.let {
                        Logger.e("LOG LIST MOVIES ERROR", it)
                        errorHandler.showError(it)
                    }
                })
        }
    }

    private fun showProgressBar() {
        progressBarVisibility.value = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBarVisibility.value = View.GONE
    }
}