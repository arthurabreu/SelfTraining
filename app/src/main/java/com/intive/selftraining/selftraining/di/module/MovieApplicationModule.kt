package com.intive.selftraining.selftraining.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class MovieApplicationModule(private val context: Context) {

    @Provides
    fun provideApplication(): Context {
        return context
    }
}
