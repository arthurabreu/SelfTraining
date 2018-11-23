package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkInterface {

    @GET("discover/movie/")
    fun getListMovies(): Observable<ApiMoviesResponse>

    @GET("configuration")
    fun getConfiguration(): Observable<ApiConfiguration>
}