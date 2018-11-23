package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.ZipListMovies
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import com.intive.selftraining.selftraining.network.models.ApiConfiguration
import com.intive.selftraining.selftraining.network.models.ApiResult

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<ApiResult> = emptyList()
    private lateinit var apiConfiguration: ApiConfiguration

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && resultsList.size > position) {
            resultsList.let { }
                holder.bind(resultsList[position], apiConfiguration)
        }
    }

    fun update(items: ZipListMovies) {
        this.resultsList = items.apiMoviesResponse.apiResults
        this.apiConfiguration = items.apiConfiguration
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
            mapper: ListMoviesMapper
        ) {
            binding.text = mapper.apiResults.
            binding.image = apiConfiguration.images.base_url + apiConfiguration.images.logo_sizes[5] + apiResult.poster_path
        }
    }
}
