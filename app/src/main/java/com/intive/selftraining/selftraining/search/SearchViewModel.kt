package com.intive.selftraining.selftraining.search

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.intive.selftraining.selftraining.utils.mvvm.RxViewModel
import timber.log.Timber

class SearchViewModel(
    private val repo: ListMoviesRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) : RxViewModel(), LifecycleObserver {

    val searchList: MutableLiveData<List<Movie>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getMoviesResponse()
    }

    private fun getMoviesResponse() {

        launch {
            repo.getMovies()
                .subscribeOn(customScheduler.io())
                .observeOn(customScheduler.ui())
                .subscribe({
                    Timber.d(it.toString())
                    searchList.value = it
                }, { error ->
                    error.message?.let {
                        Timber.e(it)
                        errorHandler.showError(it)
                    }
                })
        }
    }
}
