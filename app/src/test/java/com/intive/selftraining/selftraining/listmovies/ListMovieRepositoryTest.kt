package com.intive.selftraining.selftraining.listmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito

class ListMovieRepositoryTest {

    private val movie = getMovieEntity()

    private val configuration = getConfigurationEntity()

    private val url = imgUrl()

    private val networkClient = mock<NetworkInterface>()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return MovieDetailsEntity when ask for getMovie()`() {

        val movieObservable = Observable.just(movie)

        Mockito.`when`(networkClient.getListMovies()).thenReturn(movieObservable)

        networkClient.getListMovies().test().assertValue(movie)
    }

    @Test
    fun `should return ConfigurationEntity when ask for getConfiguration()`() {

        val configurationObservable = Observable.just(configuration)

        Mockito.`when`(networkClient.getConfiguration()).thenReturn(configurationObservable)

        networkClient.getConfiguration().test().assertValue(configuration)
    }

    @Test
    fun `should return image url after zip getConfiguration() and getMovieDetails()`() {

        val urlCommon =
            configuration.images.base_url + configuration.images.logo_sizes[0] + movie.results[0].poster_path

        urlCommon `should equal` url
    }

    private fun imgUrl(): String {
        return getConfigurationEntity().images.base_url + getConfigurationEntity().images.logo_sizes[0] + getMovieEntity().results[0].poster_path
    }

    private fun getMovieEntity(): MoviesResponseEntity {

        return Model().readJSONMovieFromAsset()
    }

    private fun getConfigurationEntity(): ConfigurationEntity {

        return Model().readJSONImagesFromAsset()
    }
}