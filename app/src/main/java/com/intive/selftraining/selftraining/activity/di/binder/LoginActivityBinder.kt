package com.intive.selftraining.selftraining.activity.di.binder

import com.intive.selftraining.selftraining.activity.LoginActivity
import com.intive.selftraining.selftraining.activity.di.component.LoginActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(LoginActivityComponent::class))
internal abstract class LoginActivityBinder {

    @Binds
    @IntoMap
    @ClassKey(LoginActivity::class)
    internal abstract fun bindLoginInjectorFactory(builder: LoginActivityComponent.Builder):
        AndroidInjector.Factory<*>
}