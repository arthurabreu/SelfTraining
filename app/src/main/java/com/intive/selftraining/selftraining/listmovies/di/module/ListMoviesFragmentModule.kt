package com.intive.selftraining.selftraining.listmovies.di.module

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.listmovies.di.factory.ListMoviesProviderFactory
import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class ListMoviesFragmentModule {

    @FragmentScope
    @Provides
    fun providesListMoviesViewModelFactory(
        repo: ListMoviesRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler
    ): ListMoviesProviderFactory {
        return ListMoviesProviderFactory(
            repo,
            customScheduler,
            errorHandler
        )
    }

    @FragmentScope
    @Provides
    fun providesListMoviesViewModel(
        fragment: ListMoviesFragment,
        factory: ListMoviesProviderFactory
    ): ListMoviesViewModel {
        return ViewModelProviders.of(fragment, factory).get(ListMoviesViewModel::class.java)
    }
}