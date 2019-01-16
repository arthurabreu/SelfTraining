package com.intive.selftraining.selftraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    //private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.title = "TEST"

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController?.navigate(R.id.fragment_list_movies)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//
//        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
//        searchView.queryHint = getString(R.string.search)
//        searchView?.setOnQueryTextListener(searchViewModel)
//        searchView.setIconifiedByDefault(false)
//        searchView.setOnSearchClickListener {
//            Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.searchFragment)
//        }
//
//        return true
//    }

    //TODO create toolbar binding adapter and a boolean field to show or hide the SearchView when I want and do the querylistener in the adapter
}
