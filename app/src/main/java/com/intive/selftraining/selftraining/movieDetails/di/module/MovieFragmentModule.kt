package com.intive.selftraining.selftraining.movieDetails.di.module

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.movieDetails.adapter.MoviesPagerAdapter
import com.intive.selftraining.selftraining.movieDetails.di.factory.MovieProviderFactory
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class MovieFragmentModule() {

    @FragmentScope
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

    @FragmentScope
    @Provides
    fun providesMovieDetailsViewModel(
        fragment: MovieDetailsFragment,
        factory: MovieProviderFactory
    ): MovieDetailsViewModel {
        return ViewModelProviders.of(fragment, factory).get(MovieDetailsViewModel::class.java)
    }

    @FragmentScope
    @Provides
    fun provideVerticalViewPagerAdapter(fragment: MovieDetailsFragment): MoviesPagerAdapter {
        return MoviesPagerAdapter(fragment.fragmentManager!!)
    }
}