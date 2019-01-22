package com.intive.selftraining.selftraining.search

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.intive.selftraining.selftraining.network.CustomScheduler
import com.intive.selftraining.selftraining.utils.ErrorHandler
import com.intive.selftraining.selftraining.utils.mvvm.RxViewModel
import timber.log.Timber

class SearchViewModel(
    private val repo: SearchRepository,
    private val customScheduler: CustomScheduler,
    private val errorHandler: ErrorHandler
) : RxViewModel(), LifecycleObserver, SearchView.OnQueryTextListener{

    val searchList: MutableLiveData<List<SearchMovie>> = MutableLiveData()
    val showSearch: MutableLiveData<Boolean> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        showSearch.value = true
    }

     private fun getMoviesResponse(query: String) {

        launch {
            repo.search(query)
                .subscribeOn(customScheduler.io())
                .observeOn(customScheduler.ui())
                .subscribe({
                    Timber.d(it.toString())
                    searchList.value = it
                }, { error ->
                    error.message?.let {
                        Timber.e(it)
                        errorHandler.showError(it)
                    }
                })
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        if(!query.isNullOrEmpty()){
           getMoviesResponse(query)
        }

        Timber.d(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}

