package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.network.models.Configuration
import com.intive.selftraining.selftraining.network.models.Result

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<Result> = emptyList()
    private lateinit var configuration: Configuration

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ItemViewHolder(parent)
    }

    override fun getItemCount() = resultsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && resultsList.size > position) {
            resultsList.let { }
                holder.bind(resultsList[position], configuration)
        }
    }

    fun update(items: List<Result>) {
        this.resultsList = items
        notifyDataSetChanged()
    }

    fun updateConfig(items: Configuration) {
        this.configuration = items
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
            item: Result,
            configuration: Configuration?
        ) {
            binding.text = item.title
            binding.image = configuration?.images?.base_url + configuration?.images?.logo_sizes?.get(5) + item.poster_path
        }
    }
}
