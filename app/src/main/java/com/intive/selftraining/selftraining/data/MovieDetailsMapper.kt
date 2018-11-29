package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy

class MovieDetailsMapper {
    fun mapFromEntity(movieDetailsEntitiy: MovieDetailsEntitiy, imagesEntity: ImagesEntity) =
        MovieDetails().apply {
            this.backdrop_path = movieDetailsEntitiy.backdrop_path
            this.apply { movieDetailsEntitiy.genres.forEach { this.genre = this.genre + " " + it.name } }
            this.id = movieDetailsEntitiy.id
            this.overview = movieDetailsEntitiy.overview
            this.poster_path = movieDetailsEntitiy.poster_path
            this.release_date = movieDetailsEntitiy.release_date
            this.title = movieDetailsEntitiy.title
            this.vote_average = movieDetailsEntitiy.vote_average
            this.completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] +
                movieDetailsEntitiy.poster_path
        }
}