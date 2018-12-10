package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.model.getConfigurationEntity
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.amshove.kluent.`should equal`
import org.junit.Test

class ListMovieRepositoryTest {

    var networkClient: NetworkInterface = mock {
        on { getListMovies() } doReturn getMoviesObservable()
        on { getConfiguration() } doReturn getConfigurationObservable()
    }

    val listMovieRepository = ListMoviesRepository(networkClient)

    @Test
    fun `should return values when ask for getMovieDetails(id)`() {

        listMovieRepository.getMovies().test().assertValue { l ->
            l[0].title `should equal` "Venom"
            l[0].posterPath `should equal` "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
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