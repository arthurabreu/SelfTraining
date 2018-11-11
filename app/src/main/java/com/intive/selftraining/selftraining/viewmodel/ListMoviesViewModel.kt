package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl

class ListMoviesViewModel(repo: ListMoviesRepositoryImpl) : ViewModel() {

    private val listMoviesRepository = repo
    private val moviesListMutableLive = MutableLiveData<MoviesResponse>()

    init {
        listMoviesRepository.showMovies {
            moviesListMutableLive.postValue(it)
        }
    }

    fun getListMovies() = moviesListMutableLive


    override fun onCleared() {
        listMoviesRepository.dispose()
        super.onCleared()
    }
}