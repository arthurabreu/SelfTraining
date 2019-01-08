package com.intive.selftraining.selftraining.movieDetails

import android.content.Context
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import com.intive.selftraining.selftraining.model.ViewModelTest
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMovieDetailsEntity
import com.intive.selftraining.selftraining.movieDetails.model.MovieDatabase
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.amshove.kluent.`should equal`
import org.junit.After
import org.junit.Before
import org.junit.Test

import androidx.test.core.app.ApplicationProvider

class MovieDetailsViewModelTest : ViewModelTest() {

    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn Observable.just(getMovieDetailsEntity())
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
    }

    lateinit var bufferoosDatabase: MovieDatabase
    lateinit var movieRepository: MovieRepository

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Before
    fun initDb() {
        bufferoosDatabase = Room.inMemoryDatabaseBuilder(
            context,
            MovieDatabase::class.java).build()
        movieRepository = MovieRepository(networkClient,bufferoosDatabase)
    }

    @After
    fun closeDb() {
        bufferoosDatabase.close()
    }




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
    fun `should return MovieDetails when value of movie changes`() {
        viewModel.movieId.value = 1
        viewModel.onCreate()
        viewModel.movie.value `should equal` MovieDetails()
    }
}