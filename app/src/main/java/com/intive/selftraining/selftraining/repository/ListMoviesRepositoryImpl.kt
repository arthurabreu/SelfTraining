package com.intive.selftraining.selftraining.repository

import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.utils.AppConstants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMoviesRepositoryImpl {

    private val client by lazy {
        NetworkClient.create(AppConstants.url)
    }

    fun showMovies(): Observable<MoviesResponse> {
        return client.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
