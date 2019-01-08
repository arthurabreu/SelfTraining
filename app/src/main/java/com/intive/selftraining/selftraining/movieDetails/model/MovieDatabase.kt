package com.intive.selftraining.selftraining.movieDetails.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails

@Database(entities = [(MovieDetails::class)], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDetailsDao(): MovieDetailsDao
}