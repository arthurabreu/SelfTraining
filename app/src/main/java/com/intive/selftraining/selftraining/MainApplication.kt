package com.intive.selftraining.selftraining

import android.app.Application
import com.intive.selftraining.selftraining.module.appmodule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appmodule))
    }
}