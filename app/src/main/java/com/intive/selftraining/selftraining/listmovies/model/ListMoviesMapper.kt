package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse

class ListMoviesMapper {

    var page: Int = 0
    var apiResults: List<Results> = emptyList()
    var totalPages: Int = 0
    var totalResults: Int = 0

    //Api Result data class model
    class Results{
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

    //Special field for image url
    var completeImageUrl: String = ""

    fun fromApi(apiMoviesResponse: ApiMoviesResponse, apiConfiguration: ApiConfiguration)= ListMoviesMapper().apply {

        page = apiMoviesResponse.page
        totalPages = apiMoviesResponse.total_pages
        totalResults = apiMoviesResponse.total_results


        //id = results.id


//        id = apiResult.id
//        title = apiResult.title
//        releaseDate = apiResult.release_date
//        posterPath = apiResult.poster_path
//        adult = apiResult.adult
//        backdropPath = apiResult.backdrop_path
//        genreIds = apiResult.genre_ids
//        originalLanguage = apiResult.original_language
//        originalTitle = apiResult.original_title
//        overview = apiResult.overview
//        popularity = apiResult.popularity
//        video = apiResult.video
//        voteAverage = apiResult.vote_average
//        voteCount = apiResult.vote_count

        changeKeys = apiConfiguration.change_keys
        backdropSizes = apiConfiguration.images.backdrop_sizes
        baseImageUrl = apiConfiguration.images.base_url
        logoSizes = apiConfiguration.images.logo_sizes
        posterSizes = apiConfiguration.images.poster_sizes
        profileSizes = apiConfiguration.images.profile_sizes
        secureImageBaseUrl = apiConfiguration.images.secure_base_url
        stillSizes = apiConfiguration.images.still_sizes

        //completeImageUrl = baseImageUrl + logoSizes + posterPath
    }
}

