package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ApiResult

class Results {
    var id: Int = 0
    var title: String = ""
    var releaseDate: String = ""
    var posterPath: String = ""
    var adult: Boolean = false
    var backdropPath: String = ""
    var genreIds: List<Int> = emptyList()
    var originalLanguage: String = ""
    var originalTitle: String = ""
    var overview: String = ""
    var popularity: Double = 0.0
    var video: Boolean = false
    var voteAverage: Double = 0.0
    var voteCount: Int = 0

    fun fromApi(apiResults: ApiResult) {
        id = apiResults.id
        title = apiResults.title
        releaseDate = apiResults.release_date
        posterPath = apiResults.poster_path
        adult = apiResults.adult
        backdropPath = apiResults.backdrop_path
        genreIds = apiResults.genre_ids
        originalLanguage = apiResults.original_language
        originalTitle = apiResults.original_title
        overview = apiResults.overview
        popularity = apiResults.popularity
        video = apiResults.video
        voteAverage = apiResults.vote_average
        voteCount = apiResults.vote_count
    }

    // Special field for image url
    var completeImageUrl: String = ""
}