package com.intive.selftraining.selftraining

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.intive.selftraining.selftraining.module.appmodule
import com.intive.selftraining.selftraining.view.ListMoviesActivity
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        startKoin(this, listOf(appmodule))

        startActivity(Intent(this, ListMoviesActivity::class.java))
    }
}
