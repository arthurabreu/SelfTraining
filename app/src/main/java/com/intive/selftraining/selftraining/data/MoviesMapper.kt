package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity

class MoviesMapper {
    fun mapFromEntity(moviesResponseEntity: MoviesResponseEntity, imagesEntity: ImagesEntity) =
        mutableListOf<Movies>().apply {
            moviesResponseEntity.results.forEach {
                Movies().run {
                    this.id = it.id
                    this.title = it.title
                    this.releaseDate = it.release_date
                    this.posterPath = it.poster_path
                    this.adult = it.adult
                    this.backdropPath = it.backdrop_path
                    this.genreIds = it.genre_ids
                    this.originalLanguage = it.original_language
                    this.originalTitle = it.original_title
                    this.overview = it.overview
                    this.popularity = it.popularity
                    this.video = it.video
                    this.voteAverage = it.vote_average
                    this.voteCount = it.vote_count
                    this.completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] + this.posterPath

                    add(this)
                }
            }
        }
}