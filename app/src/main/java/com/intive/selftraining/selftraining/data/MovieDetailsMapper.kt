package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.intive.selftraining.selftraining.utils.ORIGINAL_LOGO_SIZE

class MovieDetailsMapper {
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
//            val imageSize =
//                if (imagesEntity.logo_sizes.size >= ORIGINAL_LOGO_SIZE + 1)
//                    imagesEntity.logo_sizes[ORIGINAL_LOGO_SIZE] else "original"
            completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[10]  + movieDetailsEntitiy.poster_path
        }
}