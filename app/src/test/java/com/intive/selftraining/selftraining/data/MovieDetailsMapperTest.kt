package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.model.getImagesEntity
import com.intive.selftraining.selftraining.model.getMovieDetails
import com.intive.selftraining.selftraining.model.getMovieDetailsEntity
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntity
import org.amshove.kluent.`should equal`
import org.junit.Test

class MovieDetailsMapperTest {

    val mapper = MovieDetailsMapper()
    val movieDetails: MovieDetails = getMovieDetails()
    val movieDetailsEntity: MovieDetailsEntity = getMovieDetailsEntity()
    val imagesEntity: ImagesEntity = getImagesEntity()

    @Test
    fun `map from entity`() {
        mapper.mapFromEntity(movieDetailsEntity, imagesEntity, video) `should equal` movieDetails
    }
}