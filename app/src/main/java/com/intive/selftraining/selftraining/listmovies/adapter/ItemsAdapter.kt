package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.R.id.movieDetailsFragment
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.ItemListener
import com.intive.selftraining.selftraining.listmovies.MOVIE_ID
import com.intive.selftraining.selftraining.listmovies.model.Movie

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && resultsList.size > position) {
                holder.bind(resultsList[position])
        }
    }

    fun update(items: List<Movie>) {
        this.resultsList = items
        notifyDataSetChanged()
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false
        )
    ) : ViewHolder(binding.root), ItemListener {
        var movie: Movie? = null
        override fun onClick(view: View) {
            val args = Bundle()
            movie?.id?.let { args.putInt(MOVIE_ID, it) }
            Navigation.findNavController(view).navigate(movieDetailsFragment, args)
        }

        fun bind(item: Movie) {
            this.movie = item
            binding.adapter = this
            binding.text = item.title
            binding.image = item.completeImageUrl
        }
    }
}
