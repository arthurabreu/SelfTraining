package com.intive.selftraining.selftraining.search

import com.intive.selftraining.selftraining.data.SearchMovieMapper
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.intive.selftraining.selftraining.search.model.SearchMovie
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables

class SearchRepository(private val networkClient: NetworkInterface) {

    fun search(query: String): Observable<List<SearchMovie>> {
        return Observables.zip(searchMovie(query), getConfiguration()) { movies, configuration ->
            SearchMovieMapper().mapFromEntity(movies, configuration.images)
        }
    }

    private fun searchMovie(query: String): Observable<MoviesResponseEntity> = networkClient.searchMovies(query)

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
}