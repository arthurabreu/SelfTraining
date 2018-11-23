package com.intive.selftraining.selftraining.network.models

data class ApiMoviesResponse(
    val page: Int,
    val apiResults: List<ApiResult>,
    val total_pages: Int,
    val total_results: Int
)
