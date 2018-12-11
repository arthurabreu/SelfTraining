package com.intive.selftraining.selftraining.listmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ListMoviesViewModelTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    var networkClient: NetworkInterface = mock {
        on { getListMovies() } doReturn Observable.just(getMoviesResponseEntity())
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
    }
    val listMoviesRepository = mock<ListMoviesRepository>() {
        on { getMovies() } doReturn Observable.just(listOf(Movie()))
    }

    var testSchedulers: CustomScheduler = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }

    val viewModel by lazy { ListMoviesViewModel(listMoviesRepository, testSchedulers) }

    @Test
    fun getResultsList() {
        viewModel.onCreate()
        // viewModel.resultsList.value `should equal` getMoviesResponseEntity()
    }
}