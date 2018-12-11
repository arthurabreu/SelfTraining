package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.ViewModelTest
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMovieDetails
import com.intive.selftraining.selftraining.model.getMovieDetailsEntity
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.amshove.kluent.`should equal`
import org.junit.Test

class MovieDetailsViewModelTest : ViewModelTest() {
    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn Observable.just(getMovieDetailsEntity())
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
    }
    val movieRepository = MovieRepository(networkClient)

    var testSchedulers: CustomScheduler = mock {
        on { io() } doReturn Schedulers.trampoline()
        on { ui() } doReturn Schedulers.trampoline()
    }

    var errorHandler: ErrorHandler = mock()

    val viewModel: MovieDetailsViewModel by lazy {
        MovieDetailsViewModel(
            movieRepository,
            testSchedulers,
            errorHandler
        )
    }

    @Test
    fun getResultsList() {
//        viewModel.movieId.value = 1
        viewModel.onCreate()
        viewModel.movie.value `should equal` getMovieDetails()
    }
}