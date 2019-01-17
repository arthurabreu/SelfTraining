package com.intive.selftraining.selftraining.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.MoviesDetailsFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.getMovieId
import com.intive.selftraining.selftraining.movieDetails.adapter.MoviesPagerAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {
    @Inject
    lateinit var movieViewModel: MovieDetailsViewModel

    private lateinit var binding: MoviesDetailsFragmentBinding

    @Inject
    lateinit var pagerAdapterMovie: MoviesPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<MoviesDetailsFragmentBinding>(
            inflater,
            R.layout.movies_details_fragment,
            container,
            false
        ).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(movieViewModel)
        binding.run {
            viewModel = movieViewModel.apply {
                movieId.value = getMovieId()
                binding.pagerAdapter = pagerAdapterMovie
            }
            setLifecycleOwner(this@MovieDetailsFragment)
        }
    }
}