package com.intive.selftraining.selftraining.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
        val view = activityDetails?.apply {
            viewModel = movieDetailsViewModel.apply {
                movieId.value = getMovieId()
            }
            setLifecycleOwner(this@MovieDetailsFragment)
        }?.root
        val toolbar = activity?.findViewById(R.id.toolbar_main) as? Toolbar
        toolbar?.visibility = GONE
        return view
    }
}