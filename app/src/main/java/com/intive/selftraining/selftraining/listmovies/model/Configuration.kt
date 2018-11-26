package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ImagesEntity

/**
 * Representation for a [ConfigurationEntity] fetched from an external layer data source
 */
data class Configuration(
    val changeKeys: List<String>,
    val images: ImagesEntity
)