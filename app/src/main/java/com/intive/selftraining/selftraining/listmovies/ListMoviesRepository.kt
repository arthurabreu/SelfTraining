package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.data.MoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository(private val networkClient: NetworkInterface) {

    fun getMovies(): Observable<List<Movies>> {
        return Observables.zip(showMovies(), getConfiguration()) {
                movies, configuration ->
            MoviesMapper().mapFromEntity(movies, configuration.images)
        }
    }

    private fun showMovies(): Observable<MoviesResponseEntity> {
        return networkClient.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
