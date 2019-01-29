package com.intive.selftraining.selftraining

import android.app.Activity
import android.app.Application
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.intive.selftraining.selftraining.di.component.DaggerMovieApplicationComponent
import com.intive.selftraining.selftraining.di.component.MovieApplicationComponent
import com.intive.selftraining.selftraining.di.module.MovieApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {

    lateinit var component: MovieApplicationComponent

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        GoogleSignIn.getClient(this, gso)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        setup()
    }

    fun setup() {
        component = DaggerMovieApplicationComponent.builder()
            .movieApplicationModule(MovieApplicationModule(this)).build()
        component.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}