package com.intive.selftraining.selftraining.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.utils.AppConstants
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.repository.ListMoviesRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ListMoviesViewModel(val repo: ListMoviesRepositoryImpl) : ViewModel() {

    private var disposable: Disposable? = null

    fun sayMovie() = "${repo.showMovie()}"

    private val client by lazy {
        NetworkClient.create(AppConstants.url)
    }

    fun showMovies() {
        disposable = client.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> getResponse(result) },
                { error -> Log.e("ERROR", error.message) }
            )
    }

    private fun getResponse(result: MoviesResponse?) {
        Log.v("ARTICLES", "" + result)
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}