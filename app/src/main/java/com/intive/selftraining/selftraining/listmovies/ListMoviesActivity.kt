package com.intive.selftraining.selftraining.listmovies

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.activity_main.recycler_movies
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)

        this.observeLifecycleIn(listMoviesViewModel)

        activityMainBinding?.run {
            this.viewModel = listMoviesViewModel
            initRecycler()
            setLifecycleOwner(this@ListMoviesActivity)
        }
    }

    private fun LifecycleOwner.observeLifecycleIn(observer: LifecycleObserver) =
        lifecycle.addObserver(observer)

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)

        recycler_movies.layoutManager = layoutManager
        recycler_movies.hasFixedSize()
        recycler_movies.adapter = ItemsAdapter()
        recycler_movies.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
    }
}