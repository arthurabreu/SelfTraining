package com.intive.selftraining.selftraining.model

import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.BelongsToCollectionEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy

fun getMovieDetailsEntity(title: String = ""): MovieDetailsEntitiy {
    return MovieDetailsEntitiy(
        false,
        "",
        BelongsToCollectionEntity("", 0, "", ""),
        0,
        emptyList(),
        "",
        0,
        "",
        "",
        "",
        "",
        0.0,
        "",
        emptyList(),
        emptyList(),
        "",
        0,
        0,
        emptyList(),
        "",
        "",
        title,
        false,
        0.0,
        0
    )
}

fun getMoviesResponseEntity(): MoviesResponseEntity {
    return MoviesResponseEntity(
        0,
        listOf(getMovieEntity()),
        0,
        0
    )
}

fun getMovieEntity(): MoviesEntity {
    return MoviesEntity(
        false,
        "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg",
        listOf(878),
        0,
        "",
        "",
        "",
        1.0,
        "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
        "",
        "Venom",
        false,
        6.6,
        10
    )
}

fun getMovie(): Movie {
    return Movie(
        0,
        "Venom",
        "",
        "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
        false,
        listOf(878),
        "",
        "",
        "",
        1.0,
        false,
        6.6,
        10,
        "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

    )
}

fun getMovieForMapper(): Movie {
    return Movie(
        0,
        "Venom",
        "",
        "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
        false,
        listOf(878),
        "",
        "",
        "",
        1.0,
        false,
        6.6,
        10,
        "http://image.tmdb.org/t/p/original/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

    )
}

fun getConfigurationEntity(): ConfigurationEntity {
    return ConfigurationEntity(
        emptyList(), ImagesEntity(
            emptyList(),
            "",
            listOf("", "", "", "", "", "", ""),
            emptyList(),
            emptyList(),
            "",
            emptyList()
        )
    )
}

fun getImagesEntity(): ImagesEntity {
    return ImagesEntity(
        emptyList(),
        "http://image.tmdb.org/t/p/",
        listOf("original", "original", "original", "original", "original", "original", "original"),
        emptyList(),
        emptyList(),
        "",
        emptyList()
    )
}

fun getMovieDetails(): MovieDetails {
    return MovieDetails().apply { completeImageUrl = "http://image.tmdb.org/t/p/original" }
}
