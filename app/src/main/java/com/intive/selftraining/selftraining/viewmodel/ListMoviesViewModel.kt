package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl

class ListMoviesViewModel(val repo: ListMoviesRepositoryImpl) : ViewModel() {

    fun sayMovie() = "${repo.showMovie()}"
}