package com.intive.selftraining.selftraining.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieMapperTest {

    //val mapper = mock<MoviesMapper>()
    val movies: MutableList<Movie> = getMoviesList()
    val moviesTitle: MutableList<Movie> = getMoviesOnlytitle()
    val emptyMovies: MutableList<Movie> = getEmptyMovie()

    var moviesResponseEntity = mock<MoviesResponseEntity>()
    var imagesEntity = mock<ImagesEntity>()

    var mapper: MoviesMapper = mock {
        on { mapFromEntity(moviesResponseEntity, imagesEntity) } doReturn movies
    }

    var mapperEmpty: MoviesMapper = mock {
        on { mapFromEntity(moviesResponseEntity, imagesEntity) } doReturn emptyMovies
    }

    var mapperTitle: MoviesMapper = mock {
        on { mapFromEntity(moviesResponseEntity, imagesEntity) } doReturn moviesTitle
    }

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `map from entity`() {
        //`when`(mapper.mapFromEntity(moviesResponseEntity, imagesEntity)).thenReturn(movies)
        mapper.mapFromEntity(moviesResponseEntity, imagesEntity) `should equal` movies
    }

    @Test
    fun `map from entity with only title available`() {
        mapperTitle.mapFromEntity(moviesResponseEntity, imagesEntity) `should equal` moviesTitle
    }

    @Test
    fun `map from entity with movies empty`() {
        //`when`(mapper.mapFromEntity(moviesResponseEntity, imagesEntity)).thenReturn(emptyMovies)
        mapperEmpty.mapFromEntity(moviesResponseEntity, imagesEntity) `should equal` emptyMovies
    }

    private fun getMoviesList(): MutableList<Movie> {
        val movies = Movie()
        movies.id = 335983
        movies.title = "Venom"
        movies.releaseDate = "2018-10-03"
        movies.posterPath = "/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"
        movies.adult = false
        movies.genreIds = listOf(878)
        movies.originalLanguage = "en"
        movies.originalTitle = "Venom"
        movies.overview =
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \"Venom\" to save his life."
        movies.popularity = 228.224
        movies.video = false
        movies.voteAverage = 6.6
        movies.voteCount = 2192
        movies.completeImageUrl = "http://imagesEntity.tmdb.org/t/p/w500/2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg"

        return mutableListOf(movies)
    }

    private fun getMoviesOnlytitle(): MutableList<Movie> {
        val movies = Movie()
        movies.title = "Venom"

        return mutableListOf(movies)
    }

    private fun getEmptyMovie(): MutableList<Movie> {
        val movies = Movie()
        return mutableListOf(movies)
    }

}