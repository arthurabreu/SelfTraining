package com.intive.selftraining.selftraining.listmovies

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.FragmentListMoviesBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {

    private val SPAN_COUNT = 3

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

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
        val layoutManager = GridLayoutManager(context, SPAN_COUNT)

        val recyclerMovies = activityMainBinding.recyclerMovies
        recyclerMovies.layoutManager = layoutManager
        recyclerMovies.hasFixedSize()
        recyclerMovies.adapter = ItemsAdapter()
        recyclerMovies.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
    }
}
