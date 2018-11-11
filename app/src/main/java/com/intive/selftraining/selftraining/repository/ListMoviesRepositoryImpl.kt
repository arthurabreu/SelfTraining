package com.intive.selftraining.selftraining.repository

import android.util.Log
import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.utils.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

typealias MoviesCommand = (MoviesResponse) -> Unit

class ListMoviesRepositoryImpl {

    private var disposable: Disposable? = null

    private val client by lazy {
        NetworkClient.create(AppConstants.url)
    }

    internal fun showMovies(moviesCommand: MoviesCommand) {
        disposable = client.getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> getResponse(result)
                    moviesCommand.invoke(result)},
                { error -> Log.e("ERROR", error.message) }
            )
    }

    private fun getResponse(result: MoviesResponse) {
        Log.v("ARTICLES", "" + result)
    }

    fun dispose() {
        disposable?.dispose()
    }
}

