package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Result
import com.intive.selftraining.selftraining.network.models.ResultEntity

open class ResultsMapper : Mapper<ResultEntity, Result> {

    /**
     * Map a [ResultEntity] instance to a [Result] instance
     */
    override fun mapFromEntity(type: ResultEntity): Result {
        return Result(
            type.adult,
            type.backdrop_path,
            type.genre_ids,
            type.id,
            type.original_language,
            type.original_title,
            type.overview,
            type.popularity,
            type.poster_path,
            type.release_date,
            type.title,
            type.video,
            type.vote_average,
            type.vote_count
        )
    }

    /**
     * Map a [Result] instance to a [ResultEntity] instance
     */
    override fun mapToEntity(type: Result): ResultEntity {
        return ResultEntity(
            type.adult,
            type.backdropPath,
            type.genreIds,
            type.id,
            type.originalLanguage,
            type.originalTitle,
            type.overview,
            type.popularity,
            type.posterPath,
            type.releaseDate,
            type.title,
            type.video,
            type.voteAverage,
            type.voteCount
        )
    }
}