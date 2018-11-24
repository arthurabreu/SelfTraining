package com.intive.selftraining.selftraining.movieDetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.utils.AppConstants.Companion.ID
import kotlinx.android.synthetic.main.movies_details_fragment.view.grid_title

class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movies_details_fragment, container, false)
        view.grid_title.text = arguments?.getInt(ID).toString()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}