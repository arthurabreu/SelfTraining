package com.intive.selftraining.selftraining.movieDetails

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ActivityDetailsBinding
import com.intive.selftraining.selftraining.databinding.MoviesDetailsFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.activity_details.title
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.observeLifecycleIn(movieDetailsViewModel)
        val activityDetails: MoviesDetailsFragmentBinding? =
            DataBindingUtil.inflate(inflater, R.layout.movies_details_fragment, container, false)

        val view = activityDetails?.root
        activityDetails?.run {
            this.movie = movieDetailsViewModel
            setLifecycleOwner(this@MovieDetailsFragment)
        }

        return view
    }


}