package com.intive.selftraining.selftraining.movieDetails.viewPager.di.component

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.movieDetails.di.module.MovieDetailsRepoModule
import com.intive.selftraining.selftraining.movieDetails.viewPager.di.module.ImageFragmentModule
import com.intive.selftraining.selftraining.movieDetails.di.module.MovieFragmentModule
import com.intive.selftraining.selftraining.movieDetails.viewPager.ImageFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.VideoFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.di.module.VideoFragmentModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
    modules = arrayOf(
        VideoFragmentModule::class,
            MovieDetailsRepoModule::class
    )
)
interface VideoFragmentComponent :  AndroidInjector<VideoFragment>  {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<VideoFragment>()
}