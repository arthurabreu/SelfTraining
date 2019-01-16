package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.data.MovieDetailsMapper
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import com.intive.selftraining.selftraining.network.models.video.VideosResponseEntity
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables

class MovieRepository(private val networkClient: NetworkInterface, private val movieDatabase: MovieDetailsDao) {
    fun getMovieDetails(id: Int): Observable<MovieDetails> {
        return Observables.zip(showMovieDetails(id), getConfiguration(), getVideo(id)) { movie, configuration, video ->
            MovieDetailsMapper().mapFromEntity(movie, configuration.images, video)
        }
    }

    private fun showMovieDetails(id: Int): Observable<MovieDetailsEntity> = networkClient.getMovieDetails(id)

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()

    private fun getVideo(id: Int): Observable<VideosResponseEntity> = networkClient.getMovieVideos(id)
}
