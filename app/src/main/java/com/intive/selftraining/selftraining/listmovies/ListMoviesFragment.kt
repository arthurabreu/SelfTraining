package com.intive.selftraining.selftraining.listmovies

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.FragmentListMoviesBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesFragment : androidx.fragment.app.Fragment() {

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
}
