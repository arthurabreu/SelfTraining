package com.intive.selftraining.selftraining.movieDetails

import com.intive.selftraining.selftraining.movieDetails.model.Movie
import com.intive.selftraining.selftraining.network.NetworkInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepository(private val networkClient: NetworkInterface) {

    fun getMovieResult(): Observable<Movie> {
        return networkClient.getMovieById(11111)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
