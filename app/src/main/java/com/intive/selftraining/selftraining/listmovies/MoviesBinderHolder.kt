package com.intive.selftraining.selftraining.listmovies

import android.content.Intent
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.intive.selftraining.selftraining.BR
import com.intive.selftraining.selftraining.network.models.Result
import com.intive.selftraining.selftraining.detailsmovies.DetailsScopeActivity

class MoviesBinderHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    fun bind(movie: Result) {
        viewDataBinding.setVariable(BR.movie, movie)
        viewDataBinding.executePendingBindings()
        itemView.setOnClickListener {
            var intent = Intent(it.context, DetailsScopeActivity::class.java)
            intent.putExtra("VALUE", movie)
            it.context?.startActivity(intent)
            }
        }
}
