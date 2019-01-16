package com.intive.selftraining.selftraining.search.adapter

import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter

@BindingAdapter("toolbarTitle")
fun toolbarBindingTitle(toolbar: Toolbar, title: String){
    toolbar.title = title
}