package com.intive.selftraining.selftraining.repository

interface ListMoviesRepository{
    fun showMovie(): String
}

class ListMoviesRepositoryImpl() : ListMoviesRepository{
    override fun showMovie() = "Mission Impossible"
}