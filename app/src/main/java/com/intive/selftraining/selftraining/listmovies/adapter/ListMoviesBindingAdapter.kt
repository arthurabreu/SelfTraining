package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper

@BindingAdapter("resultsList")
fun RecyclerView.bindItems(items: ListMoviesMapper?) {

    items?.let { val adapter = adapter as ItemsAdapter
        adapter.update(items) }
}