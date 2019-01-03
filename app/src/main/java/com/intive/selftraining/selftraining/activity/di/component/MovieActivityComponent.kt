package com.intive.selftraining.selftraining.activity.di.component

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.activity.MainActivity
import com.intive.selftraining.selftraining.activity.di.module.ActivityModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface MovieActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}