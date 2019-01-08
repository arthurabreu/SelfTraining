package com.intive.selftraining.selftraining.movieDetails.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import io.reactivex.Single

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface MovieDetailsDao {
    @Query("SELECT * FROM movie_details")
    fun getMovieDetails(): Single<MovieDetails>

    @Query("SELECT * FROM movie_details WHERE id = :movieId")
    fun getMovieById(movieId: String): Single<MovieDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieDetails: MovieDetails)
}
