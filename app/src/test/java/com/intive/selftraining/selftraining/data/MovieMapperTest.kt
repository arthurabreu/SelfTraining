package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Movie
import com.intive.selftraining.selftraining.model.getImagesEntity
import com.intive.selftraining.selftraining.model.getMovieForMapper
import com.intive.selftraining.selftraining.model.getMoviesResponseEntity
import org.amshove.kluent.`should equal`
import org.junit.Test

class MovieMapperTest {

    var moviesResponseEntity = getMoviesResponseEntity()
    var imagesEntity = getImagesEntity()

    val movies: MutableList<Movie> = mutableListOf(getMovieForMapper()git a)

    var mapper = MoviesMapper()

    @Test
    fun `map from entity`() {
        mapper.mapFromEntity(moviesResponseEntity, imagesEntity) `should equal` movies
    }
}