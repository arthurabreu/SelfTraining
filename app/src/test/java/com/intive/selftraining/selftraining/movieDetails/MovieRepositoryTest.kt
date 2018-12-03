package com.intive.selftraining.selftraining.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.model.Model
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`

class MovieRepositoryTest {

    private val movieDetails = getMovieDetailsEntity()

    private val configuration = getConfigurationEntity()

    private val url = imgUrl()

    private val networkClient = mock<NetworkInterface>()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return MovieDetailsEntity when ask for getMovieDetails(id)`() {

        val movieDetailsObservable = Observable.just(movieDetails)

        `when`(networkClient.getMovieDetails(335983)).thenReturn(movieDetailsObservable)

        networkClient.getMovieDetails(335983).test().assertValue(movieDetails)
    }

    @Test
    fun `should return ConfigurationEntity when ask for getConfiguration()`() {

        val configurationObservable = Observable.just(configuration)

        `when`(networkClient.getConfiguration()).thenReturn(configurationObservable)

        networkClient.getConfiguration().test().assertValue(configuration)
    }

    @Test
    fun `should return image url after zip getConfiguration() and getMovieDetails(id)`() {

        val urlCommon =
            configuration.images.base_url + configuration.images.logo_sizes[0] + movieDetails.poster_path

        urlCommon `should equal` url
    }

    private fun imgUrl(): String {
        return getConfigurationEntity().images.base_url + getConfigurationEntity().images.logo_sizes[0] + getMovieDetailsEntity().poster_path
    }

    private fun getMovieDetailsEntity(): MovieDetailsEntitiy {

        return Model().getMovieDetailsEntity()
    }

    private fun getConfigurationEntity(): ConfigurationEntity {

        return Model().getConfigurationEntity()
    }
}