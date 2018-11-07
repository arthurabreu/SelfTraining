package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.repository.ListMoviesRepository

class ListMoviesViewModel(val repo : ListMoviesRepository) : ViewModel() {

    fun sayMovie() = "${repo.showMovie()}"
}