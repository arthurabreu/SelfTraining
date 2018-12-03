package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.utils.MOVIE_ID

fun Bundle.getArgs(movieDetailsViewModel: MovieDetailsViewModel){
    val id = this.getInt(MOVIE_ID)
    movieDetailsViewModel.getMovieDetails(id)
}