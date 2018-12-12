package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import com.intive.selftraining.selftraining.utils.ORIGINAL_LOGO_SIZE

class MovieDetailsMapper {
    fun mapFromEntity(movieDetailsEntity: MovieDetailsEntity, imagesEntity: ImagesEntity) =
        MovieDetails().apply {
            backdropPath = movieDetailsEntity.backdrop_path
            movieDetailsEntity.genres.forEach { this.genre = this.genre + " " + it.name }
            id = movieDetailsEntity.id
            overview = movieDetailsEntity.overview
            posterPath = movieDetailsEntity.poster_path
            releaseDate = movieDetailsEntity.release_date
            title = movieDetailsEntity.title
            voteAverage = movieDetailsEntity.vote_average
            completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[ORIGINAL_LOGO_SIZE] +
                movieDetailsEntity.poster_path
        }
}