package com.intive.selftraining.selftraining.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.amshove.kluent.`should not be null`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieRepositoryTest {

    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn Observable.just(Model().getMovieDetailsEntity(title = "Venom"))
        on { getConfiguration() } doReturn getConfigurationEntity()
    }

    val movieRepository = MovieRepository(networkClient)

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return title when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test()
            .assertValue (MovieDetails(title = "Venom"))
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
    }

    @Test
    fun `verify, that methods are called`() {
        networkClient.getConfiguration()
        networkClient.getMovieDetails(1)
        verify(networkClient, times(1)).getConfiguration()
        verify(networkClient).getMovieDetails(1)
    }

    @Test
    fun `should return noValues when one of two observable not emitted`() {
//        val scheduler = TestScheduler()
//        var movieResponse = movieRepository.showMovieDetails(1).subscribeOn(scheduler)
//        movieRepository.getConfiguration().zipWith(movieResponse).test().assertNoValues()
    }

    @Test
    fun `should not be null when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test().`should not be null`()
    }


    private fun getMovieDetailsEntity(): MovieDetailsEntitiy {

        return Model().getMovieDetailsEntity()
    }

    private fun getConfigurationEntity(): Observable<ConfigurationEntity> {

        return Observable.just(Model().getConfigurationEntity())
    }
}