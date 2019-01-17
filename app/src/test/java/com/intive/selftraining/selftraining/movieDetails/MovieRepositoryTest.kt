package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMovieDetailsEntity
import com.intive.selftraining.selftraining.model.getVideosResponseEntity
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.amshove.kluent.`should not be null`
import org.junit.Test

class MovieRepositoryTest {

    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn Observable.just(getMovieDetailsEntity(title = "Venom"))
        on { getConfiguration() } doReturn Observable.just(getConfigurationEntity())
        on { getMovieVideos(1) } doReturn Observable.just(getVideosResponseEntity())
    }

    val movieRepository = MovieRepository(networkClient, mock())

    @Test
    fun `should return title when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test()
            .assertValue(MovieDetails(title = "Venom"))
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
    }

    @Test
    fun `should return noValues when one of two observable not emitted`() {
        whenever(networkClient.getConfiguration()).thenReturn(Observable.just(mock()))
        movieRepository.getMovieDetails(1).test().assertNoValues()
    }

    @Test
    fun `should not be null when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test().`should not be null`()
    }
}