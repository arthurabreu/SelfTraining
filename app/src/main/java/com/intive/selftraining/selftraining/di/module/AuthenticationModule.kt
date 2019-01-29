package com.intive.selftraining.selftraining.di.module

import com.intive.selftraining.selftraining.authentication.Authentication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthenticationModule {
    @Singleton
    @Provides
    fun provideAuthentication(): Authentication {
        return Authentication()
    }
}