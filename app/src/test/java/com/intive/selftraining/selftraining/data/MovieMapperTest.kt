package com.intive.selftraining.selftraining.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.model.Model
import org.amshove.kluent.`should equal`
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieMapperTest {

    var moviesResponseEntity = Model().getMoviesResponseEntity()
    var imagesEntity = Model().getImagesEntity()

    val movies: MutableList<Movie> = mutableListOf(Model().getMovie())

    var mapper = MoviesMapper()

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `map from entity`() {
        mapper.mapFromEntity(moviesResponseEntity, imagesEntity) `should equal` movies
    }
}