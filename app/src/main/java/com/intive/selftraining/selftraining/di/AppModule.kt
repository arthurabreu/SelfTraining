package com.intive.selftraining.selftraining.di

import com.intive.selftraining.selftraining.repository.DetailsRespository
import com.intive.selftraining.selftraining.repository.ListMoviesRepository
import com.intive.selftraining.selftraining.viewmodel.DetailsScopeViewModel
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appmodule = module {

    single { ListMoviesRepository() }
    single { DetailsRespository() }

    scope("movies") { DetailsScopeViewModel(get()) }

    viewModel { ListMoviesViewModel(get()) }
}
