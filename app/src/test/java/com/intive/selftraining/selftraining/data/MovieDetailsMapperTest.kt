package com.intive.selftraining.selftraining.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.movieDetails.model.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import com.nhaarman.mockitokotlin2.mock
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`

class MovieDetailsMapperTest {

    private val mapper = mock<MovieDetailsMapper>()
    private val movieDetail: MovieDetails = getMovieDetails()
    private val movieDetailsEntity = mock<MovieDetailsEntitiy>()
    private val imagesEntity = mock<ImagesEntity>()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun mapFromEntity() {
        `when`(mapper.mapFromEntity(movieDetailsEntity, imagesEntity)).thenReturn(movieDetail)
    }

    private fun getMovieDetails(): MovieDetails {
        val movieDetails = MovieDetails()
        movieDetails.backdrop_path = "/VuukZLgaCrho2Ar8Scl9HtV3yD.jpg"
        movieDetails.genre = ""
        movieDetails.id = 335983
        movieDetails.overview = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life."
        movieDetails.poster_path = "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
        movieDetails.release_date = "2018-10-03"
        movieDetails.title = "Venom"
        movieDetails.vote_average = 6.6
        movieDetails.completeImageUrl = "http://imagesEntity.tmdb.org/t/p/w500/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

        return movieDetails
    }
}