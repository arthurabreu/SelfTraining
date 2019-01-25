package com.intive.selftraining.selftraining.search.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.search.SearchProvider
import com.intive.selftraining.selftraining.search.SearchRepository
import com.intive.selftraining.selftraining.search.SearchViewModel
import com.intive.selftraining.selftraining.utils.ErrorHandler

class SearchProviderFactory(
    private val repo: SearchRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler,
    private val searchProvider: SearchProvider
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repo, customScheduler, errorHandler, searchProvider) as T
    }
}
