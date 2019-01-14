package com.intive.selftraining.selftraining.search.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.intive.selftraining.selftraining.search.SearchMovie

@BindingAdapter("searchList")
fun RecyclerView.bind(movies: List<SearchMovie>?) {

    movies?.let { val adapter = adapter as SearchAdapter
        adapter.updateSearchList(movies) }
}