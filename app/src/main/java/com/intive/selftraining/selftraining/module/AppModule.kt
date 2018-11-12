package com.intive.selftraining.selftraining.module

import com.intive.selftraining.selftraining.repository.DetailsRespositoryImpl
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl
import com.intive.selftraining.selftraining.view.ListMoviesActivity
import com.intive.selftraining.selftraining.viewmodel.DetailsScopeViewModel
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appmodule = module {

    single { ListMoviesRepositoryImpl() }
    single { DetailsRespositoryImpl() }

    scope("movies") { DetailsScopeViewModel(get()) }

    viewModel { ListMoviesViewModel(get()) }
}
