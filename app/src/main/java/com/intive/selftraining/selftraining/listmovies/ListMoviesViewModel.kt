package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.intive.selftraining.selftraining.network.models.MoviesResponse
import com.intive.selftraining.selftraining.network.models.Result
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

class ListMoviesViewModel(repo: ListMoviesRepository) : ViewModel() {

//    val title = MutableLiveData<String>()

    var items : MutableLiveData<List<Result>>? = MutableLiveData<List<Result>>()

    private var observable: Observable<MoviesResponse>  =  repo.showMovies()
    private var disposable: Disposable? = null

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    fun getResult() {
        disposable = observable.subscribe(
            { result ->
                Log.d("RESULT", result.results.toString())
                items?.let { it.value  = result.results  } },
            { error -> Log.e("ERROR", error.message) })
    }
}