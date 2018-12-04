package com.intive.selftraining.selftraining.listmovies

import android.support.v4.app.Fragment

const val MOVIE_ID = "movieId"

fun Fragment.getMovieId() = arguments?.getInt(MOVIE_ID)