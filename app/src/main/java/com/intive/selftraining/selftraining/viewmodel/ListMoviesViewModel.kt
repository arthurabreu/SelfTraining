package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl

class ListMoviesViewModel(repo: ListMoviesRepositoryImpl) : ViewModel() {

    private val listMoviesRepository = repo
     val title = MutableLiveData<String>()

    init {
        listMoviesRepository.showMovies {
            title.value = it.results[0].title
//            title.postValue(it)
        }
    }

    override fun onCleared() {
        listMoviesRepository.dispose()
        super.onCleared()
    }
}