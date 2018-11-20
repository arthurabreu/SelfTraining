package com.intive.selftraining.selftraining.listmovies

import com.intive.selftraining.selftraining.network.NetworkClient
import com.intive.selftraining.selftraining.network.NetworkInterface
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.utils.AppConstants
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMoviesRepository(private val networkClient: NetworkClient) {

    fun showMovies(): Observable<MoviesResponse> {
        return getClient(AppConstants.URL).getListMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getClient(url: String): NetworkInterface {
        return networkClient.create(url)
    }
}
