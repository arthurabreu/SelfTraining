package com.intive.selftraining.selftraining.listmovies

import android.view.View
import com.intive.selftraining.selftraining.model.ViewModelTest
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMovie
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import org.amshove.kluent.`should equal`
import org.junit.Test
import java.util.concurrent.TimeUnit

class ListMovieViewModelTest : ViewModelTest() {

    var networkClient: NetworkInterface = mock {
        on { getListMovies() } doReturn Observable.just(getMoviesResponseEntity())
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
    }
    val listMoviesRepository = ListMoviesRepository(networkClient)
    var errorHandler: ErrorHandler = mock()

    val scheduler = TestScheduler()
    var movieResponse = listMoviesRepository.getMovies().delay(2, TimeUnit.SECONDS, scheduler)

    var testSchedulers: CustomScheduler = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }

    val viewModel by lazy { ListMoviesViewModel(listMoviesRepository, testSchedulers, errorHandler) }

    @Test
    fun `should return list of Movies when value of resultsList changes`() {
        viewModel.onCreate()
        viewModel.resultsList.value `should equal` listOf(getMovie())
    }

    @Test
    fun `test that the progress bar returns the correct value before, during and after fetching`() {
        viewModel.progressBarVisibility.value `should equal` View.GONE
        movieResponse.subscribe {
            viewModel.progressBarVisibility.value `should equal` View.VISIBLE
        }
        viewModel.progressBarVisibility.value `should equal` View.GONE
    }
}