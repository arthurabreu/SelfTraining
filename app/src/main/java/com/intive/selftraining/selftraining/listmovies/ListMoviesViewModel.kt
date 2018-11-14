package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel() {

//    private val disposable: Disposable = repo.showMovies().subscribe(
//                    { result -> getResponse(result) },
//                { error -> Log.e("ERROR", error.message) }
//            )

    val title = MutableLiveData<String>()

    private fun getResponse(result: List<Result>) {
        title.value = result[2].title
    }

    private val observable: Observable<MoviesResponse> = repo.showMovies()
    private var disposable: Disposable? = null

    fun getTitle() {
        disposable = observable.subscribe(
            { result -> getResponse(result.results) },
            { error -> Log.e("ERROR", error.message) })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}