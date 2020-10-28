package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.data.MoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables

class ListMoviesRepository(private val networkClient: NetworkInterface) {

    fun getMovies(): Observable<List<Movie>> {
        return Observables.zip(showMovies(), getConfiguration()) { movies, configuration ->
            MoviesMapper().mapFromEntity(movies, configuration.images)
        }
    }

    private fun showMovies(): Observable<MoviesResponseEntity> = networkClient.getListMovies()

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
}
