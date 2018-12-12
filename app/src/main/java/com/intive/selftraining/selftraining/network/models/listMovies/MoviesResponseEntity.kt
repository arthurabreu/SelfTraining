package com.intive.selftraining.selftraining.network.models.listMovies

import com.google.gson.annotations.SerializedName

data class MoviesResponseEntity(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoviesEntity>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
