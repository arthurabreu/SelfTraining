package com.intive.selftraining.selftraining.di.module

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides

@Module
class NetworkMovieModule {
    @ActivityScope
    @Provides
    fun provideMovieApiService(): NetworkInterface {
        return NetworkClient().networkResponse
    }

    @ActivityScope
    @Provides
    fun provideMovieRepo(networkInterface: NetworkInterface): MovieRepository {
        return MovieRepository(networkInterface)
    }
}