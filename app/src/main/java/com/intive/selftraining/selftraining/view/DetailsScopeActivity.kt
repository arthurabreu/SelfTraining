package com.intive.selftraining.selftraining.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.viewmodel.DetailsScopeViewModel
import kotlinx.android.synthetic.main.details_scope.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

class DetailsScopeActivity : AppCompatActivity() {

    val detailsScopeViewModel : DetailsScopeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_scope)

        bindScope(getOrCreateScope("movies"))

        title = "DetailsScopeActivity"
        text.text = detailsScopeViewModel.sayMovie()
    }
}