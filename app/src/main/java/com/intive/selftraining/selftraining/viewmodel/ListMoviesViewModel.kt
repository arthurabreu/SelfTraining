package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.intive.selftraining.selftraining.models.MoviesResponse
import com.intive.selftraining.selftraining.repository.ListMoviesRepository

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel() {

    private var moviesResponseObservable: LiveData<MoviesResponse>? = null

    init {
        moviesResponseObservable = repo.getMoviesResponse()
        repo.onCleared()
    }

    /**
     * Expose the LiveData Movies query so the UI can observe it.
     */
    fun getProjectListObservable(): LiveData<MoviesResponse>? {
        return moviesResponseObservable
    }

    override fun onCleared() {

        super.onCleared()
    }
}