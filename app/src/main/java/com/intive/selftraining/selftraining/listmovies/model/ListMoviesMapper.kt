package com.intive.selftraining.selftraining.listmovies.model

import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse

class ListMoviesMapper {

    var page: Int = 0
    var totalPages: Int = 0
    var totalResults: Int = 0
    var results: ArrayList<Results> = arrayListOf()

    // Image data class model
    var changeKeys: List<String> = emptyList()
    var backdropSizes: List<String> = emptyList()
    var baseImageUrl: String = ""
    var logoSizes: List<String> = emptyList()
    var posterSizes: List<String> = emptyList()
    var profileSizes: List<String> = emptyList()
    var secureImageBaseUrl: String = ""
    var stillSizes: List<String> = emptyList()

    fun fromApi(apiMoviesResponse: ApiMoviesResponse, apiConfiguration: ApiConfiguration) = ListMoviesMapper().apply {

        page = apiMoviesResponse.page
        totalPages = apiMoviesResponse.total_pages
        totalResults = apiMoviesResponse.total_results

        changeKeys = apiConfiguration.change_keys
        backdropSizes = apiConfiguration.images.backdrop_sizes
        baseImageUrl = apiConfiguration.images.base_url
        logoSizes = apiConfiguration.images.logo_sizes
        posterSizes = apiConfiguration.images.poster_sizes
        profileSizes = apiConfiguration.images.profile_sizes
        secureImageBaseUrl = apiConfiguration.images.secure_base_url
        stillSizes = apiConfiguration.images.still_sizes

        val tempResults: MutableList<Results> = mutableListOf()

        for (i in 0 until apiMoviesResponse.results.size) {
            val result = Results()
            result.fromApi(apiMoviesResponse.results[i])
            result.completeImageUrl = baseImageUrl + logoSizes[6] + apiMoviesResponse.results[i].poster_path
            tempResults.add(result)
        }

        results.addAll(tempResults)
    }
}
