package com.intive.selftraining.selftraining.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.intive.selftraining.selftraining.models.MoviesResponse
import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.utils.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository {

    private var disposable: Disposable? = null

    private val client by lazy {
        NetworkClient.create(AppConstants.url)
    }

    /**
     * Gets a MoviesResponse from the api and send the data back to a MutableLiveData.
     *  This MutableLiveData will be observed by the View and update it automatically
     *  if any changes occur, like retrieving data from the api.
     */
    fun getMoviesResponse(): LiveData<MoviesResponse> {
        val data: MutableLiveData<MoviesResponse> = MutableLiveData()

        disposable = client.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> data.value = result },
                { error -> Log.e("ERROR", error.message) }
            )

        return data
    }

    //TODO Where top dispose?
    fun onCleared() {
        disposable?.dispose()
    }
}