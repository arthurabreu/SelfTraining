package com.intive.selftraining.selftraining.movieDetails.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.ImageFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import com.intive.selftraining.selftraining.listmovies.getMovieId
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ImageFragment : Fragment() {
//        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return layoutInflater.inflate(R.layout.image_fragment, container, false)
//    }
    @Inject
    lateinit var viewPagerViewModel: ViewPagerViewModel

    private lateinit var binding: ImageFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<ImageFragmentBinding>(
            inflater,
            R.layout.image_fragment,
            container,
            false
        ).also {
            binding = it
        }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.observeLifecycleIn(viewPagerViewModel)
        binding.run {
            viewModel = viewPagerViewModel.apply {
                movieId.value = 297802
            }
            setLifecycleOwner(this@ImageFragment)
        }
    }
}