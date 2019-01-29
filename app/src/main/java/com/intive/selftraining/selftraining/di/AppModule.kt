package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.listmovies.ListMoviesFragment
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieDetailsViewModel
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.search.SearchFragment
import com.intive.selftraining.selftraining.search.SearchProvider
import com.intive.selftraining.selftraining.search.SearchRepository
import com.intive.selftraining.selftraining.search.SearchViewModel
import com.intive.selftraining.selftraining.utils.ErrorHandler
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { CustomScheduler() }
    factory { NetworkClient().networkResponse }
    single { ErrorHandler(get()) }

    single { ListMoviesRepository(get()) }
    single { MovieRepository(get()) }
    single { SearchRepository(get()) }

    single { ListMoviesFragment() }
    single { SearchFragment() }

    single { SearchProvider() }

    viewModel { ListMoviesViewModel(get(), get(), get()) }
    viewModel { MovieDetailsViewModel(get(), get(), get()) }
    viewModel { SearchViewModel(get(), get(), get(), get()) }
}
