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
import com.intive.selftraining.selftraining.databinding.ActivityMainBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.activity_main.recycler_movies
import org.koin.android.viewmodel.ext.android.viewModel

class ListMoviesFragment : Fragment() {

    private val listMoviesViewModel: ListMoviesViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.observeLifecycleIn(listMoviesViewModel)

        // Inflate the layout for this fragment
        val binding : ActivityMainBinding? = DataBindingUtil.inflate(inflater, R.layout.activity_main,container, false)
        var myView : View  = binding!!.root

        binding?.run {
                        this.viewModel = listMoviesViewModel
            initRecycler()
            setLifecycleOwner(this@ListMoviesFragment)
        }

        return myView
    }

    private fun initRecycler() {
        val layoutManager = GridLayoutManager(context, 3)

        recycler_movies.layoutManager = layoutManager
        recycler_movies.hasFixedSize()
        recycler_movies.adapter = ItemsAdapter()
        recycler_movies.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
    }
}
