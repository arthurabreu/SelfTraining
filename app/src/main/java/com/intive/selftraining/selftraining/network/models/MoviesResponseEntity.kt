package com.intive.selftraining.selftraining.network.models

data class MoviesResponseEntity(
    val page: Int,
    val resultEntities: List<ResultEntity>,
    val total_pages: Int,
    val total_results: Int
)
