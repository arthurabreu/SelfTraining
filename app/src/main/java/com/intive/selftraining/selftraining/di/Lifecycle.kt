package com.intive.selftraining.selftraining.di

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner

fun LifecycleOwner.observeLifecycleIn(observer: LifecycleObserver) =
    lifecycle.addObserver(observer)