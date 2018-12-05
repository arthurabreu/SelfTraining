package com.intive.selftraining.selftraining.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.data.MovieDetailsMapper
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import org.amshove.kluent.`should not be null`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import javax.xml.datatype.DatatypeConstants.SECONDS
import io.reactivex.schedulers.TestScheduler
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldBeEqualTo
import java.util.concurrent.TimeUnit

class MovieRepositoryTest {

    var networkClient: NetworkInterface = mock {
        on { getMovieDetails(1) } doReturn getMovieDetailsEntity()
        on { getConfiguration() } doReturn getConfigurationEntity()
    }
    
    val movieRepository = MovieRepository(networkClient)

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return title when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test().assertValue { l -> l.title == "Venom" }
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
    }

    @Test
    fun `should return empty when one of two observable not emitted`() {
        val scheduler = TestScheduler()
        var title = ""
        var url = ""
        scheduler.advanceTimeBy(20, TimeUnit.SECONDS)
        var movieResponse = movieRepository.showMovieDetails(1).subscribeOn(scheduler)
        var configuration = movieRepository.getConfiguration().zipWith(movieResponse)

        configuration.subscribe {
            title = it.second.title
            url = it.first.images.base_url
        }

        assertTrue(title.isEmpty())
        assertTrue(url.isEmpty())

        scheduler.advanceTimeBy(0, TimeUnit.MILLISECONDS)

        title `should be equal to` "Venom"
    }

    @Test
    fun `should not be null when ask for getMovieDetails(id)`() {
        movieRepository.getMovieDetails(1).test().`should not be null`()
    }

    private fun getMovieDetailsEntity(): Observable<MovieDetailsEntitiy> {

        return Observable.just(Model().getMovieDetailsEntity())
    }

    private fun getConfigurationEntity(): Observable<ConfigurationEntity> {

        return Observable.just(Model().getConfigurationEntity())
    }
}