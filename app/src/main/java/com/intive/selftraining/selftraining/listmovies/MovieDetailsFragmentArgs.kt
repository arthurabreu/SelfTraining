package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel

fun Bundle.getArgs(movieDetailsViewModel: MovieDetailsViewModel, id: String){
    val id = this.getInt(id)
    movieDetailsViewModel.getMovieDetails(id)
}