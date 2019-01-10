package com.intive.selftraining.selftraining.search

import com.intive.selftraining.selftraining.data.MoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables

class SearchRepository(private val networkClient: NetworkInterface) {

    fun search(query: String): Observable<List<Movie>> {
        return Observables.zip(searchMovie(query), getConfiguration()) { movies, configuration ->
            MoviesMapper().mapFromEntity(movies, configuration.images)
        }
    }

    private fun searchMovie(query: String) : Observable<MoviesResponseEntity> = networkClient.searchMovies(query)

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
}