package com.intive.selftraining.selftraining.di.module

import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.NetworkInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiService(): NetworkInterface {
        return NetworkClient().networkResponse
    }
}