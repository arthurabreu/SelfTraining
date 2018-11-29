package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity

class MoviesMapper {
    fun mapFromEntity(moviesResponseEntity: MoviesResponseEntity, imagesEntity: ImagesEntity) =
        mutableListOf<Movies>().apply {
            moviesResponseEntity.results.forEach {
                Movies().run {
                    id = it.id
                    title = it.title
                    releaseDate = it.release_date
                    posterPath = it.poster_path
                    adult = it.adult
                    backdropPath = it.backdrop_path
                    genreIds = it.genre_ids
                    originalLanguage = it.original_language
                    originalTitle = it.original_title
                    overview = it.overview
                    popularity = it.popularity
                    video = it.video
                    voteAverage = it.vote_average
                    voteCount = it.vote_count
                    completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] + posterPath

                    add(this)
                }
            }
        }
}