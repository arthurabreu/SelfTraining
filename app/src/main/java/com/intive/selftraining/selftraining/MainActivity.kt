package com.intive.selftraining.selftraining

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.intive.selftraining.selftraining.view.ListMoviesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "MainActivity"
        startActivity(Intent(this, ListMoviesActivity::class.java))
    }
}
