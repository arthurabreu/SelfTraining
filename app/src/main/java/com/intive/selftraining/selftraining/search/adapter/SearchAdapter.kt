package com.intive.selftraining.selftraining.search.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemSearchBinding
import com.intive.selftraining.selftraining.listmovies.MOVIE_ID
import com.intive.selftraining.selftraining.search.SearchMovie

class SearchAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

        private var searchList: List<SearchMovie> = emptyList()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return SearchViewHolder(parent)
        }

        override fun getItemCount(): Int {
            return searchList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if (holder is SearchViewHolder && searchList.size > position) {
                holder.bind(searchList[position])
            }
        }

        fun updateSearchList(items: List<SearchMovie>) {
            this.searchList = items
            notifyDataSetChanged()
        }

        abstract class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)

        class SearchViewHolder(
            private val parent: ViewGroup,
            private val binding: ItemSearchBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search,
                parent,
                false
            )
        ) : ViewHolder(binding.root), SearchItemListener {
            var movie: SearchMovie? = null
            override fun onClick(view: View) {
                val args = Bundle()
                movie?.id?.let { args.putInt(MOVIE_ID, it) }
                Navigation.findNavController(view).navigate(R.id.movieDetailsFragment, args)
            }

            fun bind(item: SearchMovie) {
                this.movie = item
                binding.adapter = this
                binding.text = item.title
                binding.image = item.completeImageUrl
            }
        }
}