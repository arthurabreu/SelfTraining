package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.intive.selftraining.selftraining.utils.ORIGINAL_LOGO_SIZE

class MoviesMapper {
    fun mapFromEntity(moviesResponseEntity: MoviesResponseEntity, imagesEntity: ImagesEntity) =
        mutableListOf<Movie>().apply {
            moviesResponseEntity.results.forEach {
                Movie().run {
                    id = it.id
                    title = it.title
                    releaseDate = it.releaseDate
                    posterPath = it.posterPath
                    adult = it.adult
                    genreIds = it.genreIds
                    originalLanguage = it.originalLanguage
                    originalTitle = it.originalTitle
                    overview = it.overview
                    popularity = it.popularity
                    video = it.video
                    voteAverage = it.voteAverage
                    voteCount = it.voteCount
                    completeImageUrl = imagesEntity.baseUrl + imagesEntity.logoSizes[ORIGINAL_LOGO_SIZE] + posterPath

                    add(this)
                }
            }
        }
}