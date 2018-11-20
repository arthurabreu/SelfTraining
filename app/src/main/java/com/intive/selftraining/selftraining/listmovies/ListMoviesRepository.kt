package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.utils.AppConstants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository(networkClient: NetworkClient) {

    val networkClient: NetworkClient = networkClient

    fun showMovies(): Observable<MoviesResponse> {
        return getClient(AppConstants.url).getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getConfiguration(): Observable<Configuration>{
        return getClient(AppConstants.url).getConfiguration()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getClient(url: String): NetworkInterface {
        return networkClient.create(url)
    }
}
