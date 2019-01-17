package com.intive.selftraining.selftraining.movieDetails.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.movieDetails.adapter.loadVideo
import com.intive.selftraining.selftraining.movieDetails.model.enities.MovieDetails
import com.intive.selftraining.selftraining.utils.MOVIE_VIDEO

class VideoFragment : Fragment() {

    companion object {
        fun newInstance(movieDetails: MovieDetails): Fragment {
            val videoFragment = VideoFragment()
            val args = Bundle()
            args.putSerializable(MOVIE_VIDEO, movieDetails.videoKey)
            videoFragment.arguments = args
            return videoFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.video_fragment, container, false)
        val video = view.findViewById<ImageView>(R.id.item_video_cover)
        val videoArgs = arguments?.getSerializable(MOVIE_VIDEO) as String
        video.loadVideo(videoArgs)
        return view
    }
}