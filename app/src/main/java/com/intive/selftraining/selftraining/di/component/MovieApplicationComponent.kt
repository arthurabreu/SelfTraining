package com.intive.selftraining.selftraining.di.component

import com.intive.selftraining.selftraining.MainApplication
import com.intive.selftraining.selftraining.activity.di.binder.MovieActivityBinder
import com.intive.selftraining.selftraining.di.module.MovieApplicationModule
import com.intive.selftraining.selftraining.di.module.NetworkModule
import com.intive.selftraining.selftraining.di.module.DBModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.movieDetails.di.binder.MovieDetailsFragmentBinder
import com.intive.selftraining.selftraining.listmovies.di.binder.ListMoviesFragmentBinder
import com.intive.selftraining.selftraining.movieDetails.viewPager.di.binder.MovieViewPagerFragmentBinder
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MovieApplicationModule::class,
        MovieActivityBinder::class,
        ListMoviesFragmentBinder::class,
        MovieDetailsFragmentBinder::class,
        MovieViewPagerFragmentBinder::class,
        NetworkModule::class,
        DBModule::class,
        UtilsModule::class
    ]
)
interface MovieApplicationComponent {

    fun inject(application: MainApplication)
}