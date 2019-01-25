package com.intive.selftraining.selftraining.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.SearchFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.search.adapter.SearchAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var searchViewModel: SearchViewModel

    private lateinit var binding: SearchFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<SearchFragmentBinding>(
            inflater,
            R.layout.search_fragment,
            container,
            false
        ).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(searchViewModel)
        binding.run {
            this.viewModel = searchViewModel
            initRecycler(binding)
            setLifecycleOwner(this@SearchFragment)
        }
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
}
