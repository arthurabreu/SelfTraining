package com.intive.selftraining.selftraining.detailsmovies

import com.intive.selftraining.selftraining.detailsmovies.DetailsRespository

class DetailsScopeViewModel(val repo: DetailsRespository) {

    fun sayMovie() = "${repo.showDetails()}"
}