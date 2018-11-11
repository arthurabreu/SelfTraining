package com.intive.selftraining.selftraining.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.DetailsScopeBinding
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listMoviesActivityBinding: DetailsScopeBinding? = DataBindingUtil.setContentView(this, R.layout.details_scope)

        val moviesViewModel = ViewModelProviders.of(this).get(listMoviesViewModel.javaClass)

        moviesViewModel.getListMovies().observe(this, Observer {
            it?.run {
                text.text = it.total_pages.toString()
            }
        })

        listMoviesActivityBinding?.run {
            this.dcCharacterViewModel = moviesViewModel
            setLifecycleOwner(this@ListMoviesActivity)
        }
    }
}