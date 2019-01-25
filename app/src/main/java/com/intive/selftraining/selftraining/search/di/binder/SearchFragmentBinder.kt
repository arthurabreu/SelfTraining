package com.intive.selftraining.selftraining.search.di.binder

import com.intive.selftraining.selftraining.search.di.component.SearchFragmentComponent
import com.intive.selftraining.selftraining.search.SearchFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(SearchFragmentComponent::class))
internal abstract class SearchFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(SearchFragment::class)
    internal abstract fun bindYourAFragmentInjectorFactory(builder: SearchFragmentComponent.Builder):
            AndroidInjector.Factory<*>
}