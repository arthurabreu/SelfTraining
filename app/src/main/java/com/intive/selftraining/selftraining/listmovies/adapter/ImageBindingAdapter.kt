package com.intive.selftraining.selftraining.listmovies.adapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imgUrl")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}