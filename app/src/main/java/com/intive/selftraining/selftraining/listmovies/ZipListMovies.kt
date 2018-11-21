package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.MoviesResponse

data class ZipListMovies(
    val moviesResponse: MoviesResponse,
    val configuration: Configuration
)