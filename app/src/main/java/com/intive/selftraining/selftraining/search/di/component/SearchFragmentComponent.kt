package com.intive.selftraining.selftraining.search.di.component

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.search.SearchFragment
import com.intive.selftraining.selftraining.search.di.module.SearchFragmentModule
import com.intive.selftraining.selftraining.search.di.module.SearchRepoModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(
    modules = arrayOf(
        SearchFragmentModule::class,
        SearchRepoModule::class
    )
)
interface SearchFragmentComponent : AndroidInjector<SearchFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SearchFragment>()
}