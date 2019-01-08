package com.intive.selftraining.selftraining.di.module

import android.content.Context
import androidx.room.Room
import com.intive.selftraining.selftraining.movieDetails.model.MovieDatabase
import com.intive.selftraining.selftraining.utils.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieApplicationModule(private val context: Context) {

    @Provides
    fun provideApplication(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideRoom(): MovieDatabase {
        return Room.databaseBuilder(
            context, MovieDatabase::class.java,
            DB_NAME
        ).build()
    }
}
