package com.intive.selftraining.selftraining.listmovies.di.component

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import com.intive.selftraining.selftraining.listmovies.di.module.ListMoviesFragmentModule
import com.intive.selftraining.selftraining.listmovies.di.module.ListMoviesRepoModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
    modules = arrayOf(
        ListMoviesFragmentModule::class,
        ListMoviesRepoModule::class
    )
)
interface ListMoviesFragmentComponent : AndroidInjector<ListMoviesFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ListMoviesFragment>()
}