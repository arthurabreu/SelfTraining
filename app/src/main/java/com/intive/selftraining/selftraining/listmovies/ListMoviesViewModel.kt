package com.intive.selftraining.selftraining.listmovies

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
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
        showProgressBar()
        compositeDisposable += repo.getMovies()
            .subscribeOn(customScheduler.io())
            .observeOn(customScheduler.ui()).mapNetworkErrors()
            .subscribe {
                resultsList.value = it
                hideProgressBar()
            }
    }

    private fun showProgressBar(){
        progressBarVisibility.value = View.VISIBLE
    }

    private fun hideProgressBar(){
        progressBarVisibility.value = View.GONE
    }

}