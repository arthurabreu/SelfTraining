package com.intive.selftraining.selftraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.search.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.searchView
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private val viewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.observeLifecycleIn(viewModel)
        var binding: ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        searchView?.setOnSearchClickListener {
            navController?.navigate(R.id.searchFragment)
        }

        binding?.run {
            this.searchViewModel = viewModel
            binding.searchView.setOnQueryTextListener(viewModel)
            setLifecycleOwner(this@MainActivity)
        }

        navController?.navigate(R.id.fragment_list_movies)
    }
}