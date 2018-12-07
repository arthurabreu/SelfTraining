package com.intive.selftraining.selftraining.listmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ListMovieRepositoryTest {

    var networkClient: NetworkInterface = mock {
        on { getListMovies() } doReturn getMoviesObservable()
        on { getConfiguration() } doReturn getConfigurationObservable()
    }

    val listMovieRepository = ListMoviesRepository(networkClient)

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return values when ask for getMovieDetails(id)`() {
        val showMoviesObservable = getMoviesObservable()
        val configurationObservable = getConfigurationObservable()

        listMovieRepository.getMovies(showMoviesObservable, configurationObservable).test().assertValue { l ->
            l[0].title == "Venom"
            l[0].releaseDate == "2018-10-03"
            l[0].posterPath == "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
            !l[0].adult
            !l[0].video
        }
            .assertNoErrors()
            .assertComplete()
    }

    private fun getMoviesObservable(): Observable<MoviesResponseEntity> {

        return Observable.just(getMoviesResponseEntity())
    }

    private fun getConfigurationObservable(): Observable<ConfigurationEntity> {

        return Observable.just(getConfigurationEntity())
    }
}