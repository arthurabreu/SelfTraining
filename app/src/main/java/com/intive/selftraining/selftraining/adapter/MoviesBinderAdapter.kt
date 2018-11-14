package com.intive.selftraining.selftraining.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.network.models.Result

class MoviesBinderAdapter : RecyclerView.Adapter<MoviesBinderHolder>() {

    private var movieList: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesBinderHolder {
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.list_item, parent, false)
        return MoviesBinderHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: MoviesBinderHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movieList.size

    fun setMoviesList(movieList: List<Result>) {
        this.movieList = movieList
    }
}
