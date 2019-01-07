package com.intive.selftraining.selftraining

import android.util.Log
import androidx.appcompat.widget.SearchView

class SearchResultsActivity: SearchView.OnQueryTextListener  {


    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.d("******* LOG: ", query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("*******Search: ", newText)
        return true
    }
}