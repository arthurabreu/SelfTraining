package com.intive.selftraining.selftraining.movieDetails.model

import android.content.Context
import androidx.room.Room
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.utils.DB_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailsDatabase(val context: Context) {

    private var movieDetailsDao: MovieDetailsDao = Room.databaseBuilder(
        context, MovieDatabase::class.java,
        DB_NAME
    ).build().movieDetailsDao()

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getMovieById(movieId: String) = movieDetailsDao.getMovieById(movieId)

    fun insert(movieDetails: MovieDetails) = uiScope.launch {
        withContext(Dispatchers.IO) { movieDetailsDao.insert(movieDetails) }
    }
}