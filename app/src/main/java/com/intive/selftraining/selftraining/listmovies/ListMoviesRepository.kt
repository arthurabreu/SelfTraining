package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository(private val networkClient: NetworkInterface) {

    fun showMovies(): Observable<MoviesResponse> {
        return networkClient.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getConfiguration(): Observable<Configuration> = networkClient.getConfiguration()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
