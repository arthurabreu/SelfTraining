package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
//    single { CustomScheduler() }
//    factory { NetworkClient().networkResponse }
//    single { ListMoviesRepository(get()) }
    single { MovieRepository(get()) }
//    single { ErrorHandler(get()) }

//    viewModel { ListMoviesViewModel(get(), get(), get()) }
    viewModel { MovieDetailsViewModel(get(), get(), get()) }
}
