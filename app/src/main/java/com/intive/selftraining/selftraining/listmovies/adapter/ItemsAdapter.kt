package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import com.intive.selftraining.selftraining.network.models.ApiConfiguration

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<ListMoviesMapper.Results> = emptyList()
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
                holder.bind(resultsList[position])
        }
    }

    fun update(items: ListMoviesMapper) {
        this.resultsList = items.results
        notifyDataSetChanged()
    }

    fun sendToMoviesDetails() {

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
            mapper: ListMoviesMapper.Results
        ) {
            binding.text = mapper.title
            binding.image = mapper.completeImageUrl
        }
    }
}
