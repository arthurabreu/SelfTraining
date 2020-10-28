package com.intive.selftraining.selftraining.network.models.listMovies

import com.google.gson.annotations.SerializedName

data class ConfigurationEntity(
    @SerializedName("change_keys")
    val changeKeys: List<String>,
    @SerializedName("images")
    val images: ImagesEntity
)