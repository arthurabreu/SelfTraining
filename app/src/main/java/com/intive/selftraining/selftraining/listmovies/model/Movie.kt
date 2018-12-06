package com.intive.selftraining.selftraining.listmovies.model

data class Movie (
    var id: Int = 0,
    var title: String = "",
    var releaseDate: String = "",
    var posterPath: String = "",
    var adult: Boolean = false,
    var genreIds: List<Int> = emptyList(),
    var originalLanguage: String = "",
    var originalTitle: String = "",
    var overview: String = "",
    var popularity: Double = 0.0,
    var video: Boolean = false,
    var voteAverage: Double = 0.0,
    var voteCount: Int = 0,
    var completeImageUrl: String = ""
)