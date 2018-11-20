package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkInterface {

    @GET("discover/movie/")
    fun getListMovies(): Observable<MoviesResponse>

    @GET("configuration")
    fun getConfiguration(): Observable<Configuration>
}