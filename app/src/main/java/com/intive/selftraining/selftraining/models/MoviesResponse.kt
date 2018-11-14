package com.intive.selftraining.selftraining.models

import com.intive.selftraining.selftraining.network.models.Result

data class MoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
