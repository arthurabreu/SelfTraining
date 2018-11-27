package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy

class MovieDetailsMapper {
    fun mapFromEntity(movieDetailsEntitiy: MovieDetailsEntitiy, imagesEntity: ImagesEntity): MovieDetails {
        val movieDetails = MovieDetails()
        movieDetails.backdrop_path = movieDetailsEntitiy.backdrop_path
        movieDetails.apply { movieDetailsEntitiy.genres.forEach { this.genre = this.genre + " " + it.name } }
        movieDetails.id = movieDetailsEntitiy.id
        movieDetails.overview = movieDetailsEntitiy.overview
        movieDetails.poster_path = movieDetailsEntitiy.poster_path
        movieDetails.release_date = movieDetailsEntitiy.release_date
        movieDetails.title = movieDetailsEntitiy.title
        movieDetails.vote_average = movieDetailsEntitiy.vote_average
        movieDetails.completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] +
            movieDetailsEntitiy.poster_path

        return movieDetails
    }
}