package com.intive.selftraining.selftraining.movieDetails.viewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intive.selftraining.selftraining.R
import com.intive.selftraining.selftraining.databinding.VideoFragmentBinding
import com.intive.selftraining.selftraining.di.observeLifecycleIn
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class VideoFragment : Fragment() {
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return layoutInflater.inflate(R.layout.video_fragment, container, false)
//    }

    @Inject
    lateinit var viewPagerViewModel: ViewPagerViewModel

    private lateinit var binding: VideoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<VideoFragmentBinding>(
            inflater,
            R.layout.video_fragment,
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
            setLifecycleOwner(this@VideoFragment)
        }
    }
}