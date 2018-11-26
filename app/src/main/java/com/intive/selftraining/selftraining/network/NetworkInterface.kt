package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.network.models.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkInterface {

    @GET("discover/movie/")
    fun getListMovies(): Observable<MoviesResponseEntity>

    @GET("configuration")
    fun getConfiguration(): Observable<ConfigurationEntity>
}