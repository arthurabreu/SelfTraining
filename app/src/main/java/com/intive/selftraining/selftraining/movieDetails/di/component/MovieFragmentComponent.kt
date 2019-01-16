package com.intive.selftraining.selftraining.movieDetails.di.component

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import com.intive.selftraining.selftraining.movieDetails.di.module.MovieDetailsRepoModule
import com.intive.selftraining.selftraining.movieDetails.di.module.MovieFragmentModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
    modules = arrayOf(
        MovieFragmentModule::class,
        MovieDetailsRepoModule::class
    )
)
interface MovieFragmentComponent : AndroidInjector<MovieDetailsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieDetailsFragment>()
}