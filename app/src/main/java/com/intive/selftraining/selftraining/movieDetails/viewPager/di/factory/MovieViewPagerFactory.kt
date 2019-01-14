package com.intive.selftraining.selftraining.movieDetails.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.intive.selftraining.selftraining.movieDetails.MovieRepository
import com.intive.selftraining.selftraining.movieDetails.viewPager.ViewPagerViewModel
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler

class MovieViewPagerFactory(
    private val repo: MovieRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewPagerViewModel(repo, customScheduler, errorHandler) as T
    }
}
