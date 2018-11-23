package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse

class ListMoviesMapper {

    var page: Int = 0
    var apiResults: List<Results> = emptyList()
    var totalPages: Int = 0
    var totalResults: Int = 0

    //Api Result data class model
    class Results  {
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

        //Special field for image url
        var completeImageUrl: String = ""
    }

    //Image data class model
    var changeKeys: List<String> = emptyList()
    var backdropSizes: List<String> = emptyList()
    var baseImageUrl: String = ""
    var logoSizes: List<String> = emptyList()
    var posterSizes: List<String> = emptyList()
    var profileSizes: List<String> = emptyList()
    var secureImageBaseUrl: String = ""
    var stillSizes: List<String> = emptyList()

    fun fromApi(apiMoviesResponse: ApiMoviesResponse, apiConfiguration: ApiConfiguration)= ListMoviesMapper().apply {

        page = apiMoviesResponse.page
        totalPages = apiMoviesResponse.total_pages
        totalResults = apiMoviesResponse.total_results

        var i = 0
        while (i != apiMoviesResponse.apiResults.size) {
            apiResults[i].id = apiMoviesResponse.apiResults[i].id
            apiResults[i].title = apiMoviesResponse.apiResults[i].title
            apiResults[i].releaseDate = apiMoviesResponse.apiResults[i].release_date
            apiResults[i].posterPath = apiMoviesResponse.apiResults[i].poster_path
            apiResults[i].adult = apiMoviesResponse.apiResults[i].adult
            apiResults[i].backdropPath = apiMoviesResponse.apiResults[i].backdrop_path
            apiResults[i].genreIds = apiMoviesResponse.apiResults[i].genre_ids
            apiResults[i].originalLanguage = apiMoviesResponse.apiResults[i].original_language
            apiResults[i].originalTitle = apiMoviesResponse.apiResults[i].original_title
            apiResults[i].popularity = apiMoviesResponse.apiResults[i].popularity
            apiResults[i].video = apiMoviesResponse.apiResults[i].video
            apiResults[i].voteAverage = apiMoviesResponse.apiResults[i].vote_average
            apiResults[i].voteCount = apiMoviesResponse.apiResults[i].vote_count
            apiResults[i].completeImageUrl = baseImageUrl + logoSizes + apiMoviesResponse.apiResults[i].poster_path
        }

        changeKeys = apiConfiguration.change_keys
        backdropSizes = apiConfiguration.images.backdrop_sizes
        baseImageUrl = apiConfiguration.images.base_url
        logoSizes = apiConfiguration.images.logo_sizes
        posterSizes = apiConfiguration.images.poster_sizes
        profileSizes = apiConfiguration.images.profile_sizes
        secureImageBaseUrl = apiConfiguration.images.secure_base_url
        stillSizes = apiConfiguration.images.still_sizes
    }
}

