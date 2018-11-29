package com.intive.selftraining.selftraining.movieDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.BelongsToCollectionEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`

class MovieRepositoryTest {

    private val movieDetailsData = mock<MovieDetailsEntitiy> {
        on { it.poster_path } doReturn getMovieDetailsEntity().poster_path
    }

    private val configurationEntityData = mock<ConfigurationEntity> {
        on { it.images } doReturn getConfigurationEntity().images
    }

    private val url = imgUrl()

    private val networkClient = mock<NetworkInterface>()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should return MovieDetailsEntity when ask for getMovieDetails(id)`() {

        val movieDetailsObservable = Observable.just(movieDetailsData)

        `when`(networkClient.getMovieDetails(335983)).thenReturn(movieDetailsObservable)

        networkClient.getMovieDetails(335983).test().assertValue(movieDetailsData)
    }

    @Test
    fun `should return ConfigurationEntity when ask for getConfiguration()`() {

        val configurationObservable = Observable.just(configurationEntityData)

        `when`(networkClient.getConfiguration()).thenReturn(configurationObservable)

        networkClient.getConfiguration().test().assertValue(configurationEntityData)
    }

    @Test
    fun `should return image url after zip getConfiguration() and getMovieDetails(id)`() {

        val urlCommon =
            configurationEntityData.images.base_url + configurationEntityData.images.logo_sizes[0] + movieDetailsData.poster_path

        urlCommon `should equal` url
    }

    private fun getMovieDetailsEntity(): MovieDetailsEntitiy {

        return MovieDetailsEntitiy(
            false,
            "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg",
            BelongsToCollectionEntity("", 0, "", "/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"),
            0,
            emptyList(),
            "",
            335983,
            "",
            "",
            "",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life.",
            0.0,
            "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
            emptyList(),
            emptyList(),
            "2018-10-03",
            0,
            0,
            emptyList(),
            "",
            "",
            "Venom",
            false,
            6.6,
            0
        )
    }

    private fun getConfigurationEntity(): ConfigurationEntity {

        return ConfigurationEntity(
            emptyList(), ImagesEntity(
                emptyList(), "http://image.tmdb.org/t/p/",
                listOf("original"), emptyList(), emptyList(), "", emptyList()
            )
        )
    }

    private fun imgUrl(): String {
        return getConfigurationEntity().images.base_url + getConfigurationEntity().images.logo_sizes[0] + getMovieDetailsEntity().poster_path
    }
}