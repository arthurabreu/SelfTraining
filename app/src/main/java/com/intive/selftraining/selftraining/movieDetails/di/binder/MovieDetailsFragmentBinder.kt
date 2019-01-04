package com.intive.selftraining.selftraining.listmovies.di.binder

import com.intive.selftraining.selftraining.movieDetails.MovieDetailsFragment
import com.intive.selftraining.selftraining.movieDetails.di.component.MovieFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(MovieFragmentComponent::class))
internal abstract class MovieDetailsFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(MovieDetailsFragment::class)
    internal abstract fun bindYourAFragmentInjectorFactory(builder: MovieFragmentComponent.Builder):
        AndroidInjector.Factory<*>
}