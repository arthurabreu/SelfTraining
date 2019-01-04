package com.intive.selftraining.selftraining.listmovies.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler

class ListMoviesProviderFactory(
    private val repo: ListMoviesRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListMoviesViewModel(repo, customScheduler, errorHandler) as T
    }
}
