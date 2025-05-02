package com.cody.plango.android

import android.app.Application
import com.cody.plango.android.di.appModule
import com.cody.plango.di.getSharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TripApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TripApplication)
            modules(appModule +  getSharedModules())
        }
    }
}