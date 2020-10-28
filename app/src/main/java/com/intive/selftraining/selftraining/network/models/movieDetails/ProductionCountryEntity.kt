package com.intive.selftraining.selftraining.network.models.movieDetails

import com.google.gson.annotations.SerializedName

data class ProductionCountryEntity(
    @SerializedName("iso_3166_1")
    val iso: String,
    @SerializedName("name")
    val name: String
)