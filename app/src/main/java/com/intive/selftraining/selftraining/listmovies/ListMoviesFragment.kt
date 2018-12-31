package com.intive.selftraining.selftraining.listmovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.FragmentListMoviesBinding
import com.intive.selftraining.selftraining.di.component.DaggerListMoviesFragmentComponent
import com.intive.selftraining.selftraining.di.module.ListMoviesFragmentModule
import com.intive.selftraining.selftraining.di.module.UtilsModule
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import com.intive.selftraining.selftraining.utils.SPAN_COUNT
import javax.inject.Inject

class ListMoviesFragment : Fragment() {

    @Inject
    lateinit var movieViewModel: ListMoviesViewModel

    private lateinit var binding: FragmentListMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerListMoviesFragmentComponent.builder()
            .listMoviesFragmentModule(ListMoviesFragmentModule(this@ListMoviesFragment))
            .utilsModule(context?.let { UtilsModule(it) })
            .build()
            .inject(this@ListMoviesFragment)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentListMoviesBinding>(inflater, R.layout.fragment_list_movies, container, false).also {
            binding = it
        }.root


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(movieViewModel)
        binding.run {
            this.viewModel = movieViewModel
            initRecycler(binding)
            setLifecycleOwner(this@ListMoviesFragment)
        }
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
