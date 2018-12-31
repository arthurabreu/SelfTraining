package com.intive.selftraining.selftraining.di.module.movieDetails

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsRepoModule {

    @ActivityScope
    @Provides
    fun provideRepo(networkInterface: NetworkInterface): MovieRepository {
        return MovieRepository(networkInterface)
    }
}