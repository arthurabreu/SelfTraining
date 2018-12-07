package com.intive.selftraining.selftraining.movieDetails

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.MoviesDetailsFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.getMovieId
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

        movieDetailsViewModel.onError().observe(this, Observer<String> { messageOnError(it.toString()) })

        return activityDetails?.apply {
            viewModel = movieDetailsViewModel.apply {
                movieId.value = getMovieId()
            }
            setLifecycleOwner(this@MovieDetailsFragment)
            movieDetailsViewModel.onError()
                .observe(this@MovieDetailsFragment, Observer<String> { messageOnError(it.toString()) })
        }?.root
    }

    private fun messageOnError(it: String) {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
}