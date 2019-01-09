package com.intive.selftraining.selftraining.search.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.intive.selftraining.selftraining.listmovies.model.Movie

@BindingAdapter("searchList")
fun RecyclerView.bindItems(movies: List<Movie>?) {

    movies?.let { val adapter = adapter as SearchAdapter
        adapter.updateSearchList(movies) }
}