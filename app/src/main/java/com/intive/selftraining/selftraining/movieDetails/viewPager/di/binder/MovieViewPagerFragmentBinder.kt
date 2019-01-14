package com.intive.selftraining.selftraining.movieDetails.viewPager.di.binder

import com.intive.selftraining.selftraining.movieDetails.viewPager.di.component.ImageFragmentComponent
import com.intive.selftraining.selftraining.movieDetails.viewPager.ImageFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.VideoFragment
import com.intive.selftraining.selftraining.movieDetails.viewPager.di.component.VideoFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(ImageFragmentComponent::class, VideoFragmentComponent::class))
internal abstract class MovieViewPagerFragmentBinder {

    @Binds
    @IntoMap
    @ClassKey(ImageFragment::class)
    internal abstract fun bindYourAImageFragmentInjectorFactory(builder: ImageFragmentComponent.Builder):
        AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(VideoFragment::class)
    internal abstract fun bindVideoFragmentInjectorFactory(builder: VideoFragmentComponent.Builder):
        AndroidInjector.Factory<*>

//    @Binds
//    @IntoMap
//    @ClassKey(VideoFragment::class)
//    internal abstract fun bindVideoFragmentInjectorFactory(builder: MovieFragmentComponent.Builder):
//        AndroidInjector.Factory<*>
}