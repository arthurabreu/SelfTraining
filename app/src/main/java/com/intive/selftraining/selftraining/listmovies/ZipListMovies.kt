package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse

data class ZipListMovies(
    val apiMoviesResponse: ApiMoviesResponse,
    val apiConfiguration: ApiConfiguration
)