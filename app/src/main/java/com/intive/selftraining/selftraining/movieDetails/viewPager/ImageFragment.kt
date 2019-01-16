package com.intive.selftraining.selftraining.movieDetails.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.listmovies.adapter.loadImage
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.utils.MOVIE_DETAILS

class ImageFragment : Fragment() {

    companion object {
        fun newInstance(movieDetails: MovieDetails): Fragment {
            val imageFragment = ImageFragment()
            val args: Bundle = Bundle()
            args.putSerializable(MOVIE_DETAILS, movieDetails)
            imageFragment.arguments = args
            return imageFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.image_fragment, container, false)
        var movieDetailsArgs = arguments?.getSerializable(MOVIE_DETAILS) as MovieDetails

        var mainBackdrop = view.findViewById<ImageView>(R.id.main_backdrop)
        mainBackdrop.loadImage(movieDetailsArgs.completeImageUrl)
        return view
    }
}