package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import android.support.v4.app.Fragment
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel

const val MOVIE_ID = "movieId"

fun Fragment.getMovieId() = arguments?.getInt(MOVIE_ID)