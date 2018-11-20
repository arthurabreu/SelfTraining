package com.intive.selftraining.selftraining.listmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import com.nhaarman.mockitokotlin2.mock
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ListMoviesViewModelTest {

    var listMoviesViewModel = mock<ListMoviesViewModel>()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun getMoviesResponse() {

        /* Given */
        val response = getResponse()

//        /* When */
//        whenever(listMoviesViewModel.getMoviesResponse()).thenReturn(response)
//
//        /* Then */
//        listMoviesViewModel.getMoviesResponse() `should equal` response
    }

    private fun getResponse(): MoviesResponse {
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