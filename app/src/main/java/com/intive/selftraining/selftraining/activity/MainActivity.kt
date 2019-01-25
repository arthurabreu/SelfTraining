package com.intive.selftraining.selftraining.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding
import com.intive.selftraining.selftraining.search.SearchProvider
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.searchView
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var searchProvider: SearchProvider

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        searchView?.setOnSearchClickListener {
            navController?.navigate(R.id.searchFragment)
        }

        binding?.run {
            searchProvider = this@MainActivity.searchProvider
        }

        navController?.navigate(R.id.fragment_list_movies)
    }

    override fun supportFragmentInjector() = fragmentInjector
}
