package com.intive.selftraining.selftraining.di.module

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.providerFactory.ListMoviesProviderFactory
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class ListMoviesFragmentModule(val fragment: ListMoviesFragment) {

    @Provides
    fun providesMovieViewModelFactory(repo: ListMoviesRepository, customScheduler: CustomScheduler, errorHandler: ErrorHandler): ListMoviesProviderFactory {
        return ListMoviesProviderFactory(
            repo,
            customScheduler,
            errorHandler
        )
    }

    @Provides
    fun providesDiscoverViewModel(
        factory: ListMoviesProviderFactory
    ): ListMoviesViewModel {
        return ViewModelProviders.of(fragment, factory).get(ListMoviesViewModel::class.java)
    }


}