package com.intive.selftraining.selftraining.di.module

import com.intive.selftraining.selftraining.search.SearchProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SearchProviderModule {
    @Singleton
    @Provides
    fun provideSearchProvider(): SearchProvider {
        return SearchProvider()
    }
}