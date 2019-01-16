package com.intive.selftraining.selftraining.movieDetails.adapter

import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.movieDetails.viewPager.ImageFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.VideoFragment

@BindingAdapter(value = ["adapter", "movie"], requireAll = false)
fun ViewPager.loadAdapter(moviesPagerAdapter: MoviesPagerAdapter?, movieDetails: MovieDetails?) {

    movieDetails?.let {
        val imageFragment = ImageFragment.newInstance(it)
        val videoFragment = VideoFragment.newInstance(it)

        moviesPagerAdapter.also {

            it?.addFragments(imageFragment)
            it?.addFragments(videoFragment)
        }

        this.adapter = moviesPagerAdapter
    }
}