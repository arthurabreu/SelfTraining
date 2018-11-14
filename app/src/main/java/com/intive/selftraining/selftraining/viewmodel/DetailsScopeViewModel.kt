package com.intive.selftraining.selftraining.viewmodel

import com.intive.selftraining.selftraining.repository.DetailsRespository

class DetailsScopeViewModel(val repo: DetailsRespository) {

    fun sayMovie() = "${repo.showDetails()}"
}