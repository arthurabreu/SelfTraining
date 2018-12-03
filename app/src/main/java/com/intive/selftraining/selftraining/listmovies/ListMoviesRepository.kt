package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.data.MoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables

class ListMoviesRepository(private val networkClient: NetworkInterface) {

    fun getMovies(
        showMoviesObservable: Observable<MoviesResponseEntity>,
        configurationObservable: Observable<ConfigurationEntity>
    ): Observable<List<Movie>> {
        return Observables.zip(showMoviesObservable, configurationObservable) { movies, configuration ->
            MoviesMapper().mapFromEntity(movies, configuration.images)
        }
    }

    fun showMovies(): Observable<MoviesResponseEntity> = networkClient.getListMovies()

    fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
}
