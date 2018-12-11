package com.intive.selftraining.selftraining.listmovies

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.intive.selftraining.selftraining.utils.Logger
import com.intive.selftraining.selftraining.data.mapNetworkErrors
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.CustomScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class ListMoviesViewModel(
    private val repo: ListMoviesRepository,
    private val customScheduler: CustomScheduler
) :
    ViewModel(), LifecycleObserver {

    val resultsList: MutableLiveData<List<Movie>> = MutableLiveData()
    val progressBarVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

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
        progressBarVisibility.value = View.VISIBLE
        compositeDisposable += repo.getMovies()
            .subscribeOn(customScheduler.io())
            .observeOn(customScheduler.ui()).mapNetworkErrors()
            .subscribe ({
                Logger.d("LOG LIST MOVIES MAPPER", it.toString())
                resultsList.value = it
                progressBarVisibility.value = View.GONE
            }, { error -> error.message?.let { Logger.e("LOG LIST MOVIES ERROR", it) } })
    }
}