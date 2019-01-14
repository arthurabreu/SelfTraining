package com.intive.selftraining.selftraining.movieDetails.adapter

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieVideo
import com.intive.selftraining.selftraining.utils.getYoutubeThumbnailPath
import com.intive.selftraining.selftraining.utils.getYoutubeVideoPath

@BindingAdapter("video")
fun ImageView.loadImage(movieVideo: MovieVideo?) {

    if (movieVideo != null) {
        Glide.with(context)
            .load(getYoutubeThumbnailPath(movieVideo.key))
            .apply(
                RequestOptions().centerCrop()
            )
            .into(this)
        setOnClickListener {
            val playVideoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getYoutubeVideoPath(movieVideo.key)))
            context.startActivity(playVideoIntent)
        }
    }
}