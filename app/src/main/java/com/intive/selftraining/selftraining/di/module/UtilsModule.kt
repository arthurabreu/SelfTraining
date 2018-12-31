package com.intive.selftraining.selftraining.di.module

import android.content.Context
import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides

@Module
class UtilsModule(private val context: Context) {
    @ActivityScope
    @Provides
    fun provideCustomScheduler(): CustomScheduler {
        return CustomScheduler()
    }

    @ActivityScope
    @Provides
    fun provideRepo(): ErrorHandler {
        return ErrorHandler(context)
    }
}