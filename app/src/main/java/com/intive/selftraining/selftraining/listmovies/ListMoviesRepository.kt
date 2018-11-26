package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository(private val networkClient: NetworkInterface) {

    fun getZipResult(): Observable<ListMoviesMapper> {
        return Observables.zip(showMovies(), getConfiguration()) {
                movies, configuration ->
            ListMoviesMapper().fromApi(movies, configuration)
        }
    }

    private fun showMovies(): Observable<MoviesResponseEntity> {
        return networkClient.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getConfiguration(): Observable<ApiConfiguration> = networkClient.getConfiguration()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
