package com.intive.selftraining.selftraining.di.component

import com.intive.selftraining.selftraining.di.module.listMovies.ListMoviesFragmentModule
import com.intive.selftraining.selftraining.di.module.NetworkModule
import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.di.module.listMovies.ListMoviesRepoModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import dagger.Component

@ActivityScope
@Component(
    modules = arrayOf(
        ListMoviesFragmentModule::class,
        ListMoviesRepoModule::class, NetworkModule::class, UtilsModule::class
    )
)
interface ListMoviesFragmentComponent {

    fun inject(fragment: ListMoviesFragment)
}