package com.intive.selftraining.selftraining.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.viewmodel.ListMoviesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesActivity : AppCompatActivity() {

    val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "ListMoviesActivity"
        text.text = listMoviesViewModel.sayMovie()

        btn.setOnClickListener { _ ->
            startActivity(Intent(this, DetailsScopeActivity::class.java))
        }
    }
}