package com.intive.selftraining.selftraining.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ListMoviesActivity"

        observeViewModel()
    }

    private fun observeViewModel() {
        listMoviesViewModel.getProjectListObservable()?.observe(this, Observer { moviesResponse ->
            if (moviesResponse != null) {
                Toast.makeText(this, moviesResponse?.results?.get(0)?.title, Toast.LENGTH_SHORT).show()
            }
        })
    }
}