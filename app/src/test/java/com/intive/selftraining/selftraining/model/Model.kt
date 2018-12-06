package com.intive.selftraining.selftraining.model

import com.google.gson.Gson
import com.intive.selftraining.selftraining.network.models.listMovies.ConfigurationEntity
import com.intive.selftraining.selftraining.network.models.listMovies.ImagesEntity
import com.intive.selftraining.selftraining.network.models.listMovies.MoviesResponseEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.BelongsToCollectionEntity
import com.intive.selftraining.selftraining.network.models.movieDetails.MovieDetailsEntitiy
import java.io.InputStream

class Model {
    fun readJSONMovieResponseEntityFromAsset(): MoviesResponseEntity {
        var moviesResponseEntity = MoviesResponseEntity(0, emptyList(), 0, 0)
        try {
            val inputStream: InputStream = this.javaClass.classLoader.getResourceAsStream("movies_response.json")
            val json = inputStream.bufferedReader().use { it.readText() }
            moviesResponseEntity = Gson().fromJson(json, MoviesResponseEntity::class.java)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return moviesResponseEntity
    }

    fun readJSONImagesFromAsset(): ConfigurationEntity {
        var configurationEntity = ConfigurationEntity(
            emptyList(), ImagesEntity(
                emptyList(), "",
                emptyList(), emptyList(), emptyList(), "", emptyList()
            )
        )
        try {
            val inputStream: InputStream = this.javaClass.classLoader.getResourceAsStream("images_response")
            val json = inputStream.bufferedReader().use { it.readText() }
            configurationEntity = Gson().fromJson(json, ConfigurationEntity::class.java)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return configurationEntity
    }

    fun getMovieDetailsEntity(title: String = ""): MovieDetailsEntitiy {
        return MovieDetailsEntitiy(
            false,
            "",
            BelongsToCollectionEntity("", 0, "", ""),
            0,
            emptyList(),
            "",
            0,
            "",
            "",
            "",
            "",
            0.0,
            "",
            emptyList(),
            emptyList(),
            "",
            0,
            0,
            emptyList(),
            "",
            "",
            title,
            false,
            0.0,
            0
        )
    }

    fun getConfigurationEntity(): ConfigurationEntity {
        return ConfigurationEntity(
            emptyList(), ImagesEntity(
                emptyList(),
                "",
                listOf("","","","","","",""),
                emptyList(),
                emptyList(),
                "",
                emptyList()
            )
        )
    }

    fun getImagesEntity(): ImagesEntity {
        return ImagesEntity(
            emptyList(), "http://image.tmdb.org/t/p/",
            listOf("original"), emptyList(), emptyList(), "", emptyList()
        )
    }
}