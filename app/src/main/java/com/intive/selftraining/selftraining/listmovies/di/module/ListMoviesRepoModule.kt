package com.intive.selftraining.selftraining.listmovies.di.module

import com.intive.selftraining.selftraining.di.scopes.FragmentScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class ListMoviesRepoModule {

    @FragmentScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): ListMoviesRepository {
        return ListMoviesRepository(networkInterface)
    }
}