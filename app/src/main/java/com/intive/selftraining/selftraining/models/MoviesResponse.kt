package com.intive.selftraining.selftraining.models

data class MoviesResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
