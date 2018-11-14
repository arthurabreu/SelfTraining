package com.intive.selftraining.selftraining.listmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.network.models.MoviesResponse

class ListMoviesAdapter(val onClick: (MoviesResponse) -> Unit) : RecyclerView.Adapter<ListItemViewHolder>() {
    var items: List<MoviesResponse> = emptyList()

    fun loadMovies(newItems: List<MoviesResponse>) {
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder =
        ListItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_movies_item, parent, false)
        )

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.note = items[position]
        holder.view.setOnClickListener { onClick(items[position]) }
    }
}