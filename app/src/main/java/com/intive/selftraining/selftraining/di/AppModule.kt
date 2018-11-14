package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.detailsmovies.DetailsRespository
import com.intive.selftraining.selftraining.listmovies.ListMoviesRepository
import com.intive.selftraining.selftraining.detailsmovies.DetailsScopeViewModel
import com.intive.selftraining.selftraining.listmovies.ListMoviesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appmodule = module {

    single { ListMoviesRepository() }
    single { DetailsRespository() }

    scope("movies") { DetailsScopeViewModel(get()) }

    viewModel { ListMoviesViewModel(get()) }
}
