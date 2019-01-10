package com.intive.selftraining.selftraining.movieDetails.model

import android.content.Context
import androidx.room.Room
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import com.intive.selftraining.selftraining.utils.DB_NAME

class MovieDetailsDatabase(val context: Context) {
    var movieDetailsDao: MovieDetailsDao = create()

    private fun create(): MovieDetailsDao {

        val room = Room.databaseBuilder(
            context, MovieDatabase::class.java,
            DB_NAME
        ).build()
        return room.movieDetailsDao()
    }
}