package com.intive.selftraining.selftraining.detailsmovies

class DetailsScopeViewModel(val repo: DetailsRespository) {

    fun sayMovie() = "${repo.showDetails()}"
}