package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import com.intive.selftraining.selftraining.network.models.video.VideosResponseEntity
import com.intive.selftraining.selftraining.utils.ORIGINAL_LOGO_SIZE

class MovieDetailsMapper {
    fun mapFromEntity(
        movieDetailsEntity: MovieDetailsEntity,
        imagesEntity: ImagesEntity,
        video: VideosResponseEntity
    ) =
        MovieDetails().apply {
            backdropPath = movieDetailsEntity.backdropPath
            movieDetailsEntity.genres.forEach { this.genre = this.genre + " " + it.name }
            id = movieDetailsEntity.id
            overview = movieDetailsEntity.overview
            posterPath = movieDetailsEntity.posterPath
            releaseDate = movieDetailsEntity.releaseDate
            title = movieDetailsEntity.title
            voteAverage = movieDetailsEntity.voteAverage
            completeImageUrl = imagesEntity.baseUrl + imagesEntity.logoSizes[ORIGINAL_LOGO_SIZE] +
                movieDetailsEntity.posterPath
            videoKey = video.results[0].key
        }
}