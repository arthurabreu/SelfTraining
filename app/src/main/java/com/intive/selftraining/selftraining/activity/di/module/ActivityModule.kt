package com.intive.selftraining.selftraining.activity.di.module

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.activity.LoginActivity
import com.intive.selftraining.selftraining.authentication.AuthenticationNavigation
import com.intive.selftraining.selftraining.authentication.AuthenticationUserInfo
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @ActivityScope
    @Provides
    fun provideAuthenticationUserInfo(): AuthenticationUserInfo {
        return AuthenticationUserInfo()
    }

    @ActivityScope
    @Provides
    fun provideAuthenticationNavigation(
        loginActivity: LoginActivity
    ): AuthenticationNavigation {
        return AuthenticationNavigation(loginActivity)
    }
}