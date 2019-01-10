package com.intive.selftraining.selftraining.di.module

import android.content.Context
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetailsDatabase
import com.intive.selftraining.selftraining.movieDetails.model.dao.MovieDetailsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): MovieDetailsDao {
        return MovieDetailsDatabase(context).movieDetailsDao
    }
}
