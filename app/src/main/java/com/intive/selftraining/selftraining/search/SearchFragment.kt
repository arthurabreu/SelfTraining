package com.intive.selftraining.selftraining.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.SearchFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.search.adapter.SearchAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchFragment : Fragment(), SearchView.OnQueryTextListener {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.observeLifecycleIn(searchViewModel)
        val activityMainBinding: SearchFragmentBinding? =
            DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)

        val view = activityMainBinding?.root
        activityMainBinding?.run {
            this.searchFragmentViewModel = searchViewModel
            initRecycler(activityMainBinding)
            setLifecycleOwner(this@SearchFragment)
        }

//        val searchView = activity?.findViewById<SearchView>(R.id.action_search)
//        searchView?.setOnQueryTextListener(this)

        return view
    }

    private fun initRecycler(
        activityMainBinding: SearchFragmentBinding
    ) {
        val layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, SPAN_COUNT)

        val recyclerMovies = activityMainBinding.searchList
        recyclerMovies.layoutManager = layoutManager
        recyclerMovies.hasFixedSize()
        recyclerMovies.adapter = SearchAdapter()
        recyclerMovies.addItemDecoration(
            androidx.recyclerview.widget.DividerItemDecoration(
                context,
                layoutManager.orientation
            )
        )
    }
    //TODO binding adapter for the recycler view
    //TODO binding adapter for this below

    override fun onQueryTextSubmit(query: String?): Boolean {

        if(!query.isNullOrEmpty()){
            searchViewModel.getMoviesResponse(query)
        }

        Timber.d(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}
