package com.intive.selftraining.selftraining.listmovies.di.binder

import com.intive.selftraining.selftraining.listmovies.di.component.ListMoviesFragmentComponent
import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ListMoviesFragmentComponent::class))
internal abstract class MovieFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(ListMoviesFragment::class)
    internal abstract fun bindYourAFragmentInjectorFactory(builder: ListMoviesFragmentComponent.Builder):
            AndroidInjector.Factory<*>
}