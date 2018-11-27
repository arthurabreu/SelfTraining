package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.intive.selftraining.selftraining.network.models.ImagesEntity
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity

class MoviesMapper {

    fun mapFromEntity(moviesResponseEntity: MoviesResponseEntity, imagesEntity: ImagesEntity): List<Movies> {

        val moviesListTemp = mutableListOf<Movies>()
        val moviesList = mutableListOf<Movies>()

        for (i in 0 until moviesResponseEntity.results.size) {
            val movies = Movies()
            movies.id = moviesResponseEntity.results[i].id
            movies.title = moviesResponseEntity.results[i].title
            movies.releaseDate = moviesResponseEntity.results[i].release_date
            movies.posterPath = moviesResponseEntity.results[i].poster_path
            movies.adult = moviesResponseEntity.results[i].adult
            movies.backdropPath = moviesResponseEntity.results[i].backdrop_path
            movies.genreIds = moviesResponseEntity.results[i].genre_ids
            movies.originalLanguage = moviesResponseEntity.results[i].original_language
            movies.originalTitle = moviesResponseEntity.results[i].original_title
            movies.overview = moviesResponseEntity.results[i].overview
            movies.popularity = moviesResponseEntity.results[i].popularity
            movies.video = moviesResponseEntity.results[i].video
            movies.voteAverage = moviesResponseEntity.results[i].vote_average
            movies.voteCount = moviesResponseEntity.results[i].vote_count
            movies.completeImageUrl = imagesEntity.base_url + imagesEntity.logo_sizes[6] + movies.posterPath

            moviesListTemp.add(movies)
        }

        moviesList.addAll(moviesListTemp)

        return moviesList
    }
}