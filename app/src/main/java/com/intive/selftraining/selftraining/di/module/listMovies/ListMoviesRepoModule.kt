package com.intive.selftraining.selftraining.di.module.listMovies

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class ListMoviesRepoModule {

    @ActivityScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): ListMoviesRepository {
        return ListMoviesRepository(networkInterface)
    }
}