package com.intive.selftraining.selftraining.search.di.module

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.search.SearchFragment
import com.intive.selftraining.selftraining.search.SearchProvider
import com.intive.selftraining.selftraining.search.SearchRepository
import com.intive.selftraining.selftraining.search.SearchViewModel
import com.intive.selftraining.selftraining.search.di.factory.SearchProviderFactory
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {

    @FragmentScope
    @Provides
    fun providesLSearchViewModelFactory(
        repo: SearchRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler,
        searchProvider: SearchProvider
    ): SearchProviderFactory {
        return SearchProviderFactory(
            repo,
            customScheduler,
            errorHandler,
            searchProvider
        )
    }

    @FragmentScope
    @Provides
    fun providesSearchViewModel(
        fragment: SearchFragment,
        factory: SearchProviderFactory
    ): SearchViewModel {
        return ViewModelProviders.of(fragment, factory).get(SearchViewModel::class.java)
    }
}