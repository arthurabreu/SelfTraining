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
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchFragment : Fragment(), SearchView.OnQueryTextListener  {

    private val searchViewModel: SearchViewModel by viewModel()
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
//        this.observeLifecycleIn(searchViewModel)
//         activityMainBinding =
//            DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
//
//        return activityMainBinding?.apply {
//            this.searchFragmentViewModel = searchViewModel
//            initRecycler(activityMainBinding)
//
//            setLifecycleOwner(this@SearchFragment)
//        }?.root
        DataBindingUtil.inflate<SearchFragmentBinding>(
            inflater,
            R.layout.search_fragment,
            container,
            false
        ).also {
            this.observeLifecycleIn(searchViewModel)
            binding = it
            initRecycler(binding)
        }.root


    private fun initRecycler(
        activityMainBinding: SearchFragmentBinding
    ) {
        val layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, SPAN_COUNT)

        val recyclerMovies = activityMainBinding.searchRecycler
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

        if(!query.isNullOrEmpty()){
            val args = Bundle()
            query?.let { args.putString(QUERY, query) }


            binding.run {
               // queryVM.value = getQuery()
                this.searchFragmentViewModel = searchViewModel.apply {
                    queryVM.value = getQuery()
                }
                setLifecycleOwner(this@SearchFragment)
            }
//            searchFragmentViewModel = searchViewModel.apply {
//
//            }
        }

        Timber.d(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Timber.d(newText)
        return true
    }
}
