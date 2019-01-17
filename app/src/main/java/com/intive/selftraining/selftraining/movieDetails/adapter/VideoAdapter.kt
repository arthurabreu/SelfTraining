package com.intive.selftraining.selftraining.movieDetails.adapter

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.intive.selftraining.selftraining.utils.getYoutubeThumbnailPath
import com.intive.selftraining.selftraining.utils.getYoutubeVideoPath

fun ImageView.loadVideo(videoKey: String) {

    Glide.with(context)
        .load(getYoutubeThumbnailPath(videoKey))
        .apply(
            RequestOptions().centerInside()
        )
        .into(this)
    setOnClickListener {
        val playVideoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getYoutubeVideoPath(videoKey)))
        context.startActivity(playVideoIntent)
    }
}