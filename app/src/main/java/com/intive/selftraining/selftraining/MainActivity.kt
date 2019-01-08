package com.intive.selftraining.selftraining

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    var searchResults : SearchResults = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController?.navigate(R.id.fragment_list_movies)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.queryHint = getString(R.string.search)
        searchView.setIconifiedByDefault(false)
        searchView.setOnQueryTextListener(searchResults)

        return true
    }
}
