package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.intive.selftraining.selftraining.R

@BindingAdapter("imgUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.ic_launcher_background))
            .into(this)
    }
}