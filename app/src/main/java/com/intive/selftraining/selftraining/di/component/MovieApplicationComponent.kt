package com.intive.selftraining.selftraining.di.component

import com.intive.selftraining.selftraining.MainApplication
import com.intive.selftraining.selftraining.activity.di.binder.MovieActivityBinder
import com.intive.selftraining.selftraining.di.module.MovieApplicationModule
import com.intive.selftraining.selftraining.di.module.NetworkModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.listmovies.di.binder.MovieDetailsFragmentBinder
import com.intive.selftraining.selftraining.listmovies.di.binder.ListMoviesFragmentBinder
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class, MovieApplicationModule::class,
        MovieActivityBinder::class, ListMoviesFragmentBinder::class, MovieDetailsFragmentBinder::class, NetworkModule::class, UtilsModule::class
    )
)
interface MovieApplicationComponent {

    fun inject(application: MainApplication)
}