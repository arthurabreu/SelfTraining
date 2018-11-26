package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.MutableLiveData
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.Images
import com.intive.selftraining.selftraining.network.models.ApiMoviesResponse
import org.junit.Test
import org.junit.Rule
import com.intive.selftraining.selftraining.network.models.ResultEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should equal`
import org.junit.rules.TestRule

class ListMoviesViewModelTest {

    var resultsList: MutableLiveData<ZipListMovies> = mock {
        on { value } doReturn getZipListMovies()
    }

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

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
        val conf = ApiConfiguration(emptyList(), img)
        return ZipListMovies(getMovieResponse(), conf)
    }

    private fun getMovieResponse(): ApiMoviesResponse {

        val result = ResultEntity(
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

        return ApiMoviesResponse(1, listOf(result), 19401, 388003)
    }
}