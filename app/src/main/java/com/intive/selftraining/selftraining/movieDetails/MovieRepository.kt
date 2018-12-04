package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.data.MovieDetailsMapper
import com.intive.selftraining.selftraining.data.mapNetworkErrors
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

class MovieRepository(private val networkClient: NetworkInterface, private val schedulerMovieDetails: SchedulerMovieDetails) {

    fun getMovieDetails(id: Int): Observable<MovieDetails> {
        return Observables.zip(showMovieDetails(id), getConfiguration()) { movie, configuration ->
            MovieDetailsMapper().mapFromEntity(movie, configuration.images)
        }
    }

    private fun showMovieDetails(id: Int): Observable<MovieDetailsEntitiy> {
        return networkClient.getMovieDetails(id)
            .subscribeOn(schedulerMovieDetails.io())
            .observeOn(schedulerMovieDetails.ui()).mapNetworkErrors()
    }

    private fun getConfiguration(): Observable<ConfigurationEntity> = networkClient.getConfiguration()
        .subscribeOn(schedulerMovieDetails.io())
        .observeOn(schedulerMovieDetails.ui()).mapNetworkErrors()
}
