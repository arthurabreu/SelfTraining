package com.intive.selftraining.selftraining.network.models

data class ApiMoviesResponse(
    val page: Int,
    val results: List<ApiResult>,
    val total_pages: Int,
    val total_results: Int
)
