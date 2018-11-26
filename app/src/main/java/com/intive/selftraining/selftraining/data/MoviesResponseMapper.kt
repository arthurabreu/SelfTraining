package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.MoviesResponse
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity

class MoviesResponseMapper : Mapper<MoviesResponseEntity, MoviesResponse> {

    /**
     * Map a [MoviesResponseEntity] instance to a [MoviesResponse] instance
     */
    override fun mapFromEntity(type: MoviesResponseEntity): MoviesResponse {
        return MoviesResponse(
            type.page,
            type.resultEntities, // TODO shouldn't resultEntities here be of type Result instead of ResultEntity?
            type.total_pages,
            type.total_results
        )
    }

    /**
     * Map a [MoviesResponse] instance to a [MoviesResponseEntity] instance
     */
    override fun mapToEntity(type: MoviesResponse): MoviesResponseEntity {
        return MoviesResponseEntity(
            type.page,
            type.resultEntities,
            type.totalPages,
            type.totalPages
        )
    }
}