package com.intive.selftraining.selftraining.listmovies

import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMovie
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import java.util.concurrent.TimeUnit

class ListMovieViewModelTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    var networkClient: NetworkInterface = mock {
        on { getListMovies() } doReturn Observable.just(getMoviesResponseEntity())
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
    }
    val listMoviesRepository = ListMoviesRepository(networkClient)

    val scheduler = TestScheduler()
    var movieResponse = listMoviesRepository.getMovies().delay(2, TimeUnit.SECONDS, scheduler)

    var testSchedulers: CustomScheduler = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }

    val viewModel by lazy { ListMoviesViewModel(listMoviesRepository, testSchedulers) }

    @Test
    fun `should return list of Movies when value of resultsList changes`() {
        viewModel.onCreate()
        viewModel.resultsList.value `should equal` listOf(getMovie())
    }

    @Test
    fun `test progress bar returns GONE before fetching data`() {
        viewModel.progressBarVisibility.value `should equal` 8
    }

    @Test
    fun `test progress bar returns VISIBLE during fetching`() {
        movieResponse.subscribe {
            viewModel.progressBarVisibility.value `should equal` View.VISIBLE
        }
    }

    @Test
    fun `test progress bar returns GONE after fetching data on onCreate`() {
        movieResponse = listMoviesRepository.getMovies().delay(10, TimeUnit.SECONDS, scheduler)
        movieResponse.subscribe {
            viewModel.progressBarVisibility.value `should equal` View.GONE
        }
    }
}