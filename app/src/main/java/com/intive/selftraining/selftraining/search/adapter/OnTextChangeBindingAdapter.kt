package com.intive.selftraining.selftraining.search.adapter

import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter

interface StringConsumer {
    fun invoke(argument: String?)
}

@BindingAdapter("onQueryTextSubmit", "onQueryTextChange")
fun SearchView.bindOnTextChange(
    onQueryTextSubmit: StringConsumer,
    onQueryTextChange: StringConsumer
) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false.also { onQueryTextSubmit.invoke(query) }
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false.also { onQueryTextChange.invoke(newText) }
        }
    })
}