package com.intive.selftraining.selftraining.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.intive.selftraining.selftraining.models.MoviesResponse
import kotlinx.android.synthetic.main.list_movies_item.view.list_item_title

class ListItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    var note: MoviesResponse? = null
        set(value) {
            field = value
            view.list_item_title.text = value?.results?.get(0)?.title
        }
}