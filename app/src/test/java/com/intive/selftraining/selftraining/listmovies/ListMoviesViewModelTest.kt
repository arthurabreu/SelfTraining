package com.intive.selftraining.selftraining.listmovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.Mock
import com.intive.selftraining.selftraining.network.models.Result
import org.mockito.Mockito.`when`





class ListMoviesViewModelTest {

//    lateinit var listMoviesRepository: ListMoviesRepository

//    lateinit var networkClient: NetworkClient
//    lateinit var observable: Observable<MoviesResponse>

    @Mock
    lateinit var listMoviesRepository: ListMoviesRepository

    @Mock
    lateinit var result: Result

    @Mock
    lateinit var moviesResponse: MoviesResponse

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        listMoviesRepository = mock(ListMoviesRepository::class.java)
//        result = mock(Result::class.java)
//        moviesResponse = MoviesResponse()
//        observable = listMoviesRepository.showMovies()
    }
    @Test
    fun getResultsList() {

        val result = Result(false, "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg", listOf(878), 335983, "en", "Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life.",
            228.224,
            "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg",
            "2018-10-03",
            "Venom",
        false,
            6.6,
            2192)
        val movieResponse = MoviesResponse(1, listOf(result),19401, 388003)

        val response = Observable.just(movieResponse)

        `when`(listMoviesRepository.showMovies())
            .thenReturn(response)
//        `when`(listMoviesRepository.getnnum()).thenReturn(10)
        val num =  listMoviesRepository.showMovies()

        assertEquals(listMoviesRepository.showMovies(),response)


    }

    @Test
    fun getResult() {
    }

    @Test
    fun onCleared() {
    }
}