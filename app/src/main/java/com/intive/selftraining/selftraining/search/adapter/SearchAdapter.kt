package com.intive.selftraining.selftraining.search.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.ItemListener
import com.intive.selftraining.selftraining.listmovies.MOVIE_ID
import com.intive.selftraining.selftraining.listmovies.model.Movie

class SearchAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

        private var searchList: List<Movie> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ItemViewHolder(parent)
        }

        override fun getItemCount(): Int {
            return searchList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if (holder is ItemViewHolder && searchList.size > position) {
                holder.bind(searchList[position])
            }
        }

        fun updateSearchList(items: List<Movie>) {
            this.searchList = items
            notifyDataSetChanged()
        }

        abstract class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

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
                Navigation.findNavController(view).navigate(R.id.movieDetailsFragment, args)
            }

            fun bind(item: Movie) {
                this.movie = item
                binding.adapter = this
                binding.text = item.title
                binding.image = item.completeImageUrl
            }
        }
}