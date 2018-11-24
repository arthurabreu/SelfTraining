package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ItemViewBinding
import com.intive.selftraining.selftraining.listmovies.model.ListMoviesMapper
import com.intive.selftraining.selftraining.listmovies.model.Results
import com.intive.selftraining.selftraining.movieDetails.ItemListener
import android.os.Bundle
import com.intive.selftraining.selftraining.utils.AppConstants.Companion.ID

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var resultsList: List<Results> = emptyList()

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

    fun update(items: ListMoviesMapper) {
        this.resultsList = items.results
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
        var results: Results? = null
        override fun onClick(view: View) {
            val args = Bundle()
            results?.id?.let { args.putInt(ID, it) }
            Navigation.findNavController(view).navigate(R.id.movieDetailsFragment, args)
        }

        fun bind(
            results: Results
        ) {
            this.results = results
            binding.adapter = this
            binding.text = results.title
            binding.image = results.completeImageUrl
        }
    }
}
