 package com.intive.selftraining.selftraining.listmovies.adapter

 import android.databinding.BindingAdapter
 import android.widget.ImageView
 import com.bumptech.glide.Glide

 @BindingAdapter("configuration")
 fun loadImage(ivPoster: ImageView, url: String) {
    Glide.with(ivPoster.context)
        .load(url)
        .into(ivPoster)
 }