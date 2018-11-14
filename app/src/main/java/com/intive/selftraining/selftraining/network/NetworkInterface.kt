package com.intive.selftraining.selftraining.network

import com.intive.selftraining.selftraining.models.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface NetworkInterface {

    @GET("movie/")
    fun getListMovies(): Observable<MoviesResponse>
}