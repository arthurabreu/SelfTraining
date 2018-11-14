package com.intive.selftraining.selftraining.detailsmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.network.models.Result
import kotlinx.android.synthetic.main.activity_details.details_title
import kotlinx.android.synthetic.main.activity_details.overview
import kotlinx.android.synthetic.main.activity_details.release_date
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

class DetailsScopeActivity : AppCompatActivity() {

    val detailsScopeViewModel: DetailsScopeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        bindScope(getOrCreateScope("movies"))

        val movie = intent.getSerializableExtra("VALUE") as Result
        title = movie.title
        details_title.text = movie.title
        release_date.text = movie.release_date
        overview.text = movie.overview
    }
}