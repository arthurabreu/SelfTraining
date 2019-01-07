package com.intive.selftraining.selftraining.movieDetails.model.enities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_details")
data class MovieDetails(
    @PrimaryKey @ColumnInfo(name = "id") var id: Int = 0,
    var backdropPath: String = "",
    var genre: String = "",
    var overview: String = "",
    var posterPath: String = "",
    var releaseDate: String = "",
    var title: String = "",
    var voteAverage: Double = 0.0,
    var completeImageUrl: String = ""
)