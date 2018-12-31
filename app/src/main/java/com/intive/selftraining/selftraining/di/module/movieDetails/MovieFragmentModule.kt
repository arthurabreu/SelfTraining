package com.intive.selftraining.selftraining.di.module.movieDetails

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.providerFactory.MovieProviderFactory
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class MovieFragmentModule(val fragment: MovieDetailsFragment) {

    @Provides
    fun providesMovieDetailsViewModelFactory(
        repo: MovieRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler
    ): MovieProviderFactory {
        return MovieProviderFactory(
            repo,
            customScheduler,
            errorHandler
        )
    }

    @Provides
    fun providesMovieDetailsViewModel(
        factory: MovieProviderFactory
    ): MovieDetailsViewModel {
        return ViewModelProviders.of(fragment, factory).get(MovieDetailsViewModel::class.java)
    }
}