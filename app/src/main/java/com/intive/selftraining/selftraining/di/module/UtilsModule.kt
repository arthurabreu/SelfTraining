package com.intive.selftraining.selftraining.di.module

import android.content.Context
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {
    @Singleton
    @Provides
    fun provideCustomScheduler(): CustomScheduler {
        return CustomScheduler()
    }

    @Singleton
    @Provides
    fun provideRepo(context: Context): ErrorHandler {
        return ErrorHandler(context)
    }
}