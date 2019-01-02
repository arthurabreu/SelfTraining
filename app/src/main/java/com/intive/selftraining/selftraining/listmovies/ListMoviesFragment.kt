package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.MainActivity
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.FragmentListMoviesBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.menu_main, menu)

        val item = menu.findItem(R.id.search)
        val searchView = SearchView((context as MainActivity).supportActionBar!!.themedContext)
        searchView.setOnSearchClickListener {

        }
    }
}
