package com.intive.selftraining.selftraining.di.component

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.di.module.MovieFragmentModule
import com.intive.selftraining.selftraining.di.module.NetworkMovieModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(MovieFragmentModule::class, NetworkMovieModule::class, UtilsModule::class))
interface MovieFragmentComponent {

    fun inject(fragment: MovieDetailsFragment)
}