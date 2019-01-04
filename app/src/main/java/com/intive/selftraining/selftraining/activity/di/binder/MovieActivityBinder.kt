package com.intive.selftraining.selftraining.activity.di.binder

import com.intive.selftraining.selftraining.activity.MainActivity
import com.intive.selftraining.selftraining.activity.di.component.MovieActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(MovieActivityComponent::class))
internal abstract class MovieActivityBinder {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindYourActivityInjectorFactory(builder: MovieActivityComponent.Builder):
            AndroidInjector.Factory<*>
}