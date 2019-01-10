package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.data.MovieDetailsMapper
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.Observables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val networkClient: NetworkInterface, private val movieDatabase: MovieDetailsDao) {
    fun getMovieDetails(id: Int): Observable<MovieDetails> {
        return Observables.zip(showMovieDetails(id), getConfiguration()) { movie, configuration ->
            MovieDetailsMapper().mapFromEntity(movie, configuration.images)
        }
    }

    private fun showMovieDetails(id: Int): Observable<MovieDetailsEntity> = networkClient.getMovieDetails(id)

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()

    suspend fun addMovieToDB(movieDetails: MovieDetails) {
        withContext(Dispatchers.IO) {
            movieDatabase.insert(movieDetails)
        }
    }

    fun readMovie(movieId: Int): Single<MovieDetails> {
        return movieDatabase.getMovieById(movieId.toString())
    }
}
