package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.models.MoviesResponse
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl

class ListMoviesViewModel(repo: ListMoviesRepositoryImpl) : ViewModel() {

    private var moviesResponseObservable: LiveData<MoviesResponse>? = null

    init {
        moviesResponseObservable = repo.getMoviesResponse()
    }

    /**
     * Expose the LiveData Movies query so the UI can observe it.
     */
    fun getProjectListObservable(): LiveData<MoviesResponse>? {
        return moviesResponseObservable
    }
}