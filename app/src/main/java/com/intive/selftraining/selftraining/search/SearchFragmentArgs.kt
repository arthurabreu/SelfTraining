package com.intive.selftraining.selftraining.search

import androidx.fragment.app.Fragment

const val QUERY = "query"

fun Fragment.getQuery() = arguments?.getString(QUERY)