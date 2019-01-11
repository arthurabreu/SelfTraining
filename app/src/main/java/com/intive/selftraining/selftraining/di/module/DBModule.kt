package com.intive.selftraining.selftraining.di.module

import android.content.Context
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetailsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): MovieDetailsDatabase {
        return MovieDetailsDatabase(context)
    }
}
