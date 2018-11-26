// package com.intive.selftraining.selftraining.listmovies.model
//
// import com.intive.selftraining.selftraining.network.models.ApiConfiguration
// import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity
// import com.intive.selftraining.selftraining.network.models.ResultEntity
//
// class ListMoviesMapper {
//
//    var page: Int = 0
//    var totalPages: Int = 0
//    var totalResults: Int = 0
//    var results: ArrayList<Results> = arrayListOf()
//
//    var changeKeys: List<String> = emptyList()
//    var backdropSizes: List<String> = emptyList()
//    var baseImageUrl: String = ""
//    var logoSizes: List<String> = emptyList()
//    var posterSizes: List<String> = emptyList()
//    var profileSizes: List<String> = emptyList()
//    var secureImageBaseUrl: String = ""
//    var stillSizes: List<String> = emptyList()
//
//    class Results {
//        var id: Int = 0
//        var title: String = ""
//        var releaseDate: String = ""
//        var posterPath: String = ""
//        var adult: Boolean = false
//        var backdropPath: String = ""
//        var genreIds: List<Int> = emptyList()
//        var originalLanguage: String = ""
//        var originalTitle: String = ""
//        var overview: String = ""
//        var popularity: Double = 0.0
//        var video: Boolean = false
//        var voteAverage: Double = 0.0
//        var voteCount: Int = 0
//
//        fun fromApi(resultsEntity: ResultEntity) {
//            id = resultsEntity.id
//            title = resultsEntity.title
//            releaseDate = resultsEntity.release_date
//            posterPath = resultsEntity.poster_path
//            adult = resultsEntity.adult
//            backdropPath = resultsEntity.backdrop_path
//            genreIds = resultsEntity.genre_ids
//            originalLanguage = resultsEntity.original_language
//            originalTitle = resultsEntity.original_title
//            overview = resultsEntity.overview
//            popularity = resultsEntity.popularity
//            video = resultsEntity.video
//            voteAverage = resultsEntity.vote_average
//            voteCount = resultsEntity.vote_count
//        }
//
//        var completeImageUrl: String = ""
//    }
//
//    fun fromApi(moviesResponseEntity: MoviesResponseEntity, apiConfiguration: ApiConfiguration) = ListMoviesMapper().apply {
//
//        page = moviesResponseEntity.page
//        totalPages = moviesResponseEntity.total_pages
//        totalResults = moviesResponseEntity.total_results
//
//        changeKeys = apiConfiguration.change_keys
//        backdropSizes = apiConfiguration.images.backdrop_sizes
//        baseImageUrl = apiConfiguration.images.base_url
//        logoSizes = apiConfiguration.images.logo_sizes
//        posterSizes = apiConfiguration.images.poster_sizes
//        profileSizes = apiConfiguration.images.profile_sizes
//        secureImageBaseUrl = apiConfiguration.images.secure_base_url
//        stillSizes = apiConfiguration.images.still_sizes
//
//        val tempResults: MutableList<Results> = mutableListOf()
//
//        for (i in 0 until moviesResponseEntity.resultEntities.size) {
//            val result = Results()
//            result.fromApi(moviesResponseEntity.resultEntities[i])
//            result.completeImageUrl = baseImageUrl + logoSizes[6] + moviesResponseEntity.resultEntities[i].poster_path
//            tempResults.add(result)
//        }
//
//        results.addAll(tempResults)
//    }
// }
