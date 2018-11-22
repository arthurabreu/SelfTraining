package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.ZipListMovies
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.Result

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<Result> = emptyList()
    private lateinit var configuration: Configuration

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && resultsList.size > position) {
            resultsList.let { }
                holder.bind(resultsList[position], configuration)
        }
    }

    fun update(items: ZipListMovies) {
        this.resultsList = items.moviesResponse.results
        this.configuration = items.configuration
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
    ) : ViewHolder(binding.root) {

        fun bind(
            result: Result,
            configuration: Configuration
        ) {
            binding.text = result.title
            binding.image = configuration.images.base_url + configuration.images.logo_sizes[5] + result.poster_path
        }
    }
}
