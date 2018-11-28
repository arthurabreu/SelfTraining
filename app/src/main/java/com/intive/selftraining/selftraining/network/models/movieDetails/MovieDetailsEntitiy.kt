package com.intive.selftraining.selftraining.network.models.movieDetails

data class MovieDetailsEntitiy(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollectionEntity,
    val budget: Int,
    val genres: List<GenreEntitiy>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_company: List<ProductionCompanyEntitiy>,
    val production_country: List<ProductionCountryEntity>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_language: List<SpokenLanguageEntity>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)