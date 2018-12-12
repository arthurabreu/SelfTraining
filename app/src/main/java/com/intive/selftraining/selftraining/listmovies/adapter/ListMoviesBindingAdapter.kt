package com.intive.selftraining.selftraining.listmovies.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.intive.selftraining.selftraining.listmovies.model.Movie

@BindingAdapter("resultsList")
fun RecyclerView.bindItems(items: List<Movie>?) {

    items?.let { val adapter = adapter as ItemsAdapter
        adapter.update(items) }
}