package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ResultEntity

data class MoviesResponse(
    val page: Int,
    val resultEntities: List<ResultEntity>, // TODO shouldn't resultEntities here be of type Result instead of ResultEntity?
    val totalPages: Int,
    val totalResults: Int
)