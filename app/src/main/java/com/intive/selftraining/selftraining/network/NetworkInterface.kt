package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.network.Models.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {

    @GET("movie/")
    fun getListMovies(@Query("api_key") api_key: String): Observable<MoviesResponse>
}