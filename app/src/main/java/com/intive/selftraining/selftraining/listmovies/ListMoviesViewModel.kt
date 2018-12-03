package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.data.mapNetworkErrors
import com.intive.selftraining.selftraining.listmovies.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListMoviesViewModel(private val repo: ListMoviesRepository) : ViewModel(), LifecycleObserver {

    val resultsList: MutableLiveData<List<Movie>> = MutableLiveData()

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
        val showMoviesObservable = repo.showMovies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).mapNetworkErrors()
        val configurationObservable = repo.getConfiguration().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).mapNetworkErrors()

        compositeDisposable.add(repo.getMovies(showMoviesObservable, configurationObservable).subscribe({
            resultsList.value = it
            Log.d("LIST MOVIES MAPPER", it.toString())
        }, { error -> Log.e("LIST MOVIES ERROR", error.message) }))
    }
}