/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intive.selftraining.selftraining.movieDetails.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import io.reactivex.Single

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface MovieDetailsDao {
    @Query("SELECT * FROM movie_details")
    fun getMovieDetails(): Single<MovieDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieDetails: MovieDetails)
}
