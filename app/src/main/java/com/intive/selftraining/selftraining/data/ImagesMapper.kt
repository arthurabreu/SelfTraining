package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Images
import com.intive.selftraining.selftraining.network.models.ImagesEntity

class ImagesMapper : Mapper<ImagesEntity, Images> {

    /**
     * Map a [ImagesEntity] instance to a [Images] instance
     */
    override fun mapFromEntity(type: ImagesEntity): Images {
        return Images(
            type.backdrop_sizes,
            type.base_url,
            type.logo_sizes,
            type.poster_sizes,
            type.profile_sizes,
            type.secure_base_url,
            type.still_sizes
        )
    }

    /**
     * Map a [Images] instance to a [ImagesEntity] instance
     */
    override fun mapToEntity(type: Images): ImagesEntity {
        return ImagesEntity(
            type.backdropSizes,
            type.baseUrl,
            type.logoSizes,
            type.posterSizes,
            type.profileSizes,
            type.secureBaseUrl,
            type.stillSizes
        )
    }
}