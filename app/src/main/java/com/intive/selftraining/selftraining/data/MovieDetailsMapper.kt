package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy

class MovieDetailsMapper {
    fun mapFromEntity(movieDetailsEntitiy: MovieDetailsEntitiy, imagesEntity: ImagesEntity) =
        MovieDetails().apply {
            backdrop_path = movieDetailsEntitiy.backdrop_path
            movieDetailsEntitiy.genres.forEach { this.genre = this.genre + " " + it.name }
            id = movieDetailsEntitiy.id
            overview = movieDetailsEntitiy.overview
            poster_path = movieDetailsEntitiy.poster_path
            release_date = movieDetailsEntitiy.release_date
            title = movieDetailsEntitiy.title
            vote_average = movieDetailsEntitiy.vote_average
            completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] + movieDetailsEntitiy.poster_path
        }
}