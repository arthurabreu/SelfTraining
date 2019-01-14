package com.intive.selftraining.selftraining.movieDetails.viewPager.di.module

import androidx.lifecycle.ViewModelProviders
import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.movieDetails.di.factory.MovieViewPagerFactory
import com.intive.selftraining.selftraining.movieDetails.viewPager.ImageFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.VideoFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.ViewPagerViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class VideoFragmentModule {

    @FragmentScope
    @Provides
    fun providesImageFragmentFactory(
        repo: MovieRepository,
        customScheduler: CustomScheduler,
        errorHandler: ErrorHandler
    ): MovieViewPagerFactory {
        return MovieViewPagerFactory(
            repo,
            customScheduler,
            errorHandler
        )
    }

    @FragmentScope
    @Provides
    fun providesImageFragmentViewModel(
        fragment: VideoFragment,
        factory: MovieViewPagerFactory
    ): ViewPagerViewModel {
        return ViewModelProviders.of(fragment, factory).get(ViewPagerViewModel::class.java)
    }
}