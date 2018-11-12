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
import kotlinx.android.synthetic.main.activity_main.recycler_movies
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

    private lateinit var moviesBinderAdapter: MoviesBinderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initAdapter()
        initRecycler()

        val moviesViewModel = ViewModelProviders.of(this).get(listMoviesViewModel.javaClass)

        moviesViewModel.getListMovies().observe(this, Observer {
            it?.run {
                moviesBinderAdapter.setMoviesList(it.results)
                moviesBinderAdapter.notifyDataSetChanged()
            }
        })

        activityMainBinding?.run {
            this.viewModel = moviesViewModel
            setLifecycleOwner(this@ListMoviesActivity)
        }
    }

    private fun initAdapter() {
        moviesBinderAdapter = MoviesBinderAdapter()
    }

    private fun initRecycler() {
        recycler_movies.layoutManager =  GridLayoutManager(this, 1)
        recycler_movies.setHasFixedSize(true)
        recycler_movies.adapter = moviesBinderAdapter
    }
}