package com.intive.selftraining.selftraining.listmovies

import androidx.fragment.app.Fragment

const val MOVIE_ID = "movieId"

fun Fragment.getMovieId() = arguments?.getInt(MOVIE_ID)