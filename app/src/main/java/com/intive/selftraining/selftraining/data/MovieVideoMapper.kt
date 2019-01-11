package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieVideo
import com.intive.selftraining.selftraining.network.models.video.VideosResponseEntity

class MovieVideoMapper {
    fun mapFromEntity(moviesResponseEntity: VideosResponseEntity) =
        mutableListOf<MovieVideo>().apply {
            moviesResponseEntity.results.forEach {
                MovieVideo().run {
                    id = it.id
                    key = it.key
                    name = it.name
                    add(this)
                }
            }
        }
}