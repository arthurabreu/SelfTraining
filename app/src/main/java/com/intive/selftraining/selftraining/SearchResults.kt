package com.intive.selftraining.selftraining

import android.util.Log
import androidx.appcompat.widget.SearchView

class SearchResults: SearchView.OnQueryTextListener  {


    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.d("*** onQueryTextSubmit: ", query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("*** onQueryTextChange: ", newText)
        return true
    }
}