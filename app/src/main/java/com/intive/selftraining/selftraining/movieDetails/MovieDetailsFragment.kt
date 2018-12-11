package com.intive.selftraining.selftraining.movieDetails

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.MoviesDetailsFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.getMovieId
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailsFragment : androidx.fragment.app.Fragment() {

    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.observeLifecycleIn(movieDetailsViewModel)
        val activityDetails: MoviesDetailsFragmentBinding? =
            DataBindingUtil.inflate(inflater, R.layout.movies_details_fragment, container, false)

        return activityDetails?.apply {
            viewModel = movieDetailsViewModel.apply {
                movieId.value = getMovieId()
            }
            setLifecycleOwner(this@MovieDetailsFragment)
        }?.root
    }
}