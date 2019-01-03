package com.intive.selftraining.selftraining.di.component

import com.intive.selftraining.selftraining.MainApplication
import com.intive.selftraining.selftraining.activity.di.binder.MovieActivityBinder
import com.intive.selftraining.selftraining.di.module.MovieApplicationModule
import com.intive.selftraining.selftraining.di.module.NetworkModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.listmovies.di.binder.MovieFragmentBinder
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class, MovieApplicationModule::class,
        MovieActivityBinder::class, MovieFragmentBinder::class, NetworkModule::class, UtilsModule::class
    )
)
interface MovieApplicationComponent {

    fun inject(application: MainApplication)
}