package com.intive.selftraining.selftraining.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.adapter.MoviesBinderAdapter
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityMainBinding?.run {
            this.viewModel = listMoviesViewModel
            listMoviesViewModel.getTitle()
            setLifecycleOwner(this@ListMoviesActivity)
        }
    }

}