package com.intive.selftraining.selftraining

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController?.navigate(R.id.fragment_list_movies)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val mSearch = menu?.findItem(R.id.search)
        val searchView = mSearch?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        val toast = Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT)
        toast.show()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}
