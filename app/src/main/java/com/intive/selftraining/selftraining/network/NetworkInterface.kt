package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.intive.selftraining.selftraining.network.models.video.VideosResponseEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkInterface {

    @GET("discover/movie/")
    fun getListMovies(): Observable<MoviesResponseEntity>

    @GET("configuration")
    fun getConfiguration(): Observable<ConfigurationEntity>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") groupId: Int): Observable<MovieDetailsEntity>

    @GET("movie/{id}/videos")
    fun getMovieVideos(@Path("id") movieId: Int): Observable<VideosResponseEntity>
}