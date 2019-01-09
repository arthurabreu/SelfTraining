package com.intive.selftraining.selftraining.search

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel;
import com.intive.selftraining.selftraining.listmovies.model.Movie

class SearchViewModel : ViewModel(), LifecycleObserver {

    val searchList: MutableLiveData<List<Movie>> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }
}
