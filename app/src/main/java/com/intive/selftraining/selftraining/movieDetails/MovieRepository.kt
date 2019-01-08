package com.intive.selftraining.selftraining.movieDetails

import android.os.AsyncTask
import com.intive.selftraining.selftraining.data.MovieDetailsMapper
import com.intive.selftraining.selftraining.movieDetails.model.MovieDatabase
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.Observables

class MovieRepository(private val networkClient: NetworkInterface, private val movieDatabase: MovieDatabase) {
    fun getMovieDetails(id: Int): Observable<MovieDetails> {
        return Observables.zip(showMovieDetails(id), getConfiguration()) { movie, configuration ->
            MovieDetailsMapper().mapFromEntity(movie, configuration.images)
        }
    }

    private fun showMovieDetails(id: Int): Observable<MovieDetailsEntity> = networkClient.getMovieDetails(id)

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()

    fun addMovieToDB(movieDetails: MovieDetails) {
        AsyncTask.execute {
            movieDatabase.movieDetailsDao().insert(movieDetails)
        }
    }

    fun readMoviesFromDB(): Single<MovieDetails> {
        return movieDatabase.movieDetailsDao().getMovieDetails()
    }

    fun readMovie(movieId: Int): Single<MovieDetails> {
        return movieDatabase.movieDetailsDao().getMovieById(movieId.toString())
    }
}
