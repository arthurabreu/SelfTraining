package com.intive.selftraining.selftraining.search.di.module

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.search.SearchRepository
import dagger.Module
import dagger.Provides

@Module
class SearchRepoModule {

    @FragmentScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): SearchRepository {
        return SearchRepository(networkInterface)
    }
}