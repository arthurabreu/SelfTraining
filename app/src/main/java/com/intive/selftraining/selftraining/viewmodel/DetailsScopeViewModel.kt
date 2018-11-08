package com.intive.selftraining.selftraining.viewmodel

import com.intive.selftraining.selftraining.repository.DetailsRespositoryImpl

class DetailsScopeViewModel(val repo: DetailsRespositoryImpl) {

    fun sayMovie() = "${repo.showDetails()}"
}