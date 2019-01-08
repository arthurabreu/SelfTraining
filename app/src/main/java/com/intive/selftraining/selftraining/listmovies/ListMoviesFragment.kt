package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.FragmentListMoviesBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment(),  SearchView.OnQueryTextListener {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()
    private var query = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.observeLifecycleIn(listMoviesViewModel)
        val activityMainBinding: FragmentListMoviesBinding? =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list_movies, container, false)

        val view = activityMainBinding?.root
        activityMainBinding?.run {
            this.viewModel = listMoviesViewModel
            initRecycler(activityMainBinding)
            setLifecycleOwner(this@ListMoviesFragment)
        }

        return view
    }

    private fun initRecycler(
        activityMainBinding: FragmentListMoviesBinding
    ) {
        val layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, SPAN_COUNT)

        val recyclerMovies = activityMainBinding.recyclerMovies
        recyclerMovies.layoutManager = layoutManager
        recyclerMovies.hasFixedSize()
        recyclerMovies.adapter = ItemsAdapter()
        recyclerMovies.addItemDecoration(
            androidx.recyclerview.widget.DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )
    }

    override fun onQueryTextSubmit(query: String?): Boolean {

        if(!query.isNullOrEmpty())
            this.query = query //TODO Send this query to ViewModel

        Log.d("*** onQueryTextSubmit: ", query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.d("*** onQueryTextChange: ", newText)
        return true
    }
}
