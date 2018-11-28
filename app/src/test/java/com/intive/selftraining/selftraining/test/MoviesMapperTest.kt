package com.intive.selftraining.selftraining.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.data.MoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Movies
import com.intive.selftraining.selftraining.network.models.ImagesEntity
import com.intive.selftraining.selftraining.network.models.MoviesEntity
import com.intive.selftraining.selftraining.network.models.MoviesResponseEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertEquals

class MoviesMapperTest {

    val mapper = MoviesMapper()
    var moviesEnt = getMoviesResponseEntity()
    var imagesEnt = getImagesEntity()
    val movies: List<Movies> = getMoviesList()

    var movie: MoviesResponseEntity = mock {
        on { it } doReturn moviesEnt
    }

    var image: ImagesEntity = mock{
        on { it } doReturn imagesEnt
    }

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun mapFromEntity() {
       assertEquals(mapper.mapFromEntity(movie, image), movies)
    }

    private fun getMoviesResponseEntity(): MoviesResponseEntity {
        return MoviesResponseEntity(
            1,
             listOf(getMoviesEntity()),
            1,
            1
        )
    }

    private fun getMoviesEntity(): MoviesEntity {
        return MoviesEntity(
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
    }

    private fun getImagesEntity(): ImagesEntity {
        val img = ImagesEntity(
            emptyList(),
            "http://image.tmdb.org/t/p/",
            listOf("1", "2", "3", "4", "5", "6"),
            emptyList(),
            emptyList(),
            "",
            emptyList()
        )
        return img
    }

    private fun getMoviesList(): List<Movies>{
        val movies = Movies()
        movies.id = 335983
        movies.title = "Venom"
        movies.releaseDate = "2018-10-03"
        movies.posterPath = "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
        movies.adult = false
        movies.backdropPath = "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg"
        movies.genreIds = listOf(878)
        movies.originalLanguage = "en"
        movies.originalTitle = "Venom"
        movies.overview = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life."
        movies.popularity = 228.224
        movies.video = false
        movies.voteAverage = 6.6
        movies.voteCount = 2192
        movies.completeImageUrl = "http://image.tmdb.org/t/p/w500/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

        return listOf(movies)
    }
}