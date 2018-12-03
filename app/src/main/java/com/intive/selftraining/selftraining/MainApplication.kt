package com.intive.selftraining.selftraining

import android.app.Application
import com.intive.selftraining.selftraining.di.appModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}