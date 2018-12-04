package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy

class MovieDetailsMapper {
    val ORIGINAL_LOGO_SIZE = 6
    fun mapFromEntity(movieDetailsEntitiy: MovieDetailsEntitiy, imagesEntity: ImagesEntity) =
        MovieDetails().apply {
            backdropPath = movieDetailsEntitiy.backdrop_path
            movieDetailsEntitiy.genres.forEach { this.genre = this.genre + " " + it.name }
            id = movieDetailsEntitiy.id
            overview = movieDetailsEntitiy.overview
            posterPath = movieDetailsEntitiy.poster_path
            releaseDate = movieDetailsEntitiy.release_date
            title = movieDetailsEntitiy.title
            voteAverage = movieDetailsEntitiy.vote_average
            completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[ORIGINAL_LOGO_SIZE] + movieDetailsEntitiy.poster_path
        }
}