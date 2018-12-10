package com.intive.selftraining.selftraining.listmovies.adapter

import androidx.databinding.BindingAdapter
import android.view.View
import android.widget.ProgressBar

@BindingAdapter("progressBarVisibility")
fun ProgressBar.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.INVISIBLE else View.VISIBLE
}
