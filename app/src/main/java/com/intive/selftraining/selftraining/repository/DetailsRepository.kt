package com.intive.selftraining.selftraining.repository

interface DetailsRepository{
    fun showDetails(): String
}

class DetailsRespositoryImpl() : DetailsRepository{
    override fun showDetails() = "Tom Cruise is the star of the movie"
}