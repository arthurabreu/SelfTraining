package com.intive.selftraining.selftraining

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private var navController: NavController? = null

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

//        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
//        searchView.setOnQueryTextListener(this)

//        val mSearch = menu?.findItem(R.id.search)
//        val searchView = mSearch?.actionView as SearchView
//        searchView.setIconifiedByDefault(false)
//        searchView.setOnQueryTextListener(this)

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.d("AAAAAAAA", query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("AAAAAAAA", newText)
        return false
    }
}
