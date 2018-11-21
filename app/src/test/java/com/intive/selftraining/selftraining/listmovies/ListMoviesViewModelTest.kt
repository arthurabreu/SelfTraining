package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.MutableLiveData
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.Images
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import org.junit.Test
import org.junit.Rule
import com.intive.selftraining.selftraining.network.models.Result
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.amshove.kluent.`should equal`
import org.junit.rules.TestRule
import org.junit.Before

class ListMoviesViewModelTest {

    var resultsList: MutableLiveData<ZipListMovies> = mock()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        whenever(resultsList.value).thenReturn(getZipListMovies())
    }

    @Test
    fun `when should assert zipListMovies`() {
        resultsList.value `should equal` getZipListMovies()
    }

    private fun getZipListMovies(): ZipListMovies {

        val img = Images(
            emptyList(),
            "http://image.tmdb.org/t/p/",
            listOf("1", "2", "3", "4", "5", "6"),
            emptyList(),
            emptyList(),
            "",
            emptyList()
        )
        val conf = Configuration(emptyList(), img)
        return ZipListMovies(getMovieResponse(), conf)
    }

    private fun getMovieResponse(): MoviesResponse {

        val result = Result(
            false, "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg", listOf(878), 335983, "en", "Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life.",
            228.224,
            "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
            "2018-10-03",
            "Venom",
            false,
            6.6,
            2192
        )

        return MoviesResponse(1, listOf(result), 19401, 388003)
    }
}