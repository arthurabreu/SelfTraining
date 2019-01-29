package com.intive.selftraining.selftraining.activity.di.component

import com.example.aleksandrtumanov.daggerattempts3.di.scopes.ActivityScope
import com.intive.selftraining.selftraining.activity.LoginActivity
import com.intive.selftraining.selftraining.activity.di.module.ActivityModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface LoginActivityComponent : AndroidInjector<LoginActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<LoginActivity>()
}