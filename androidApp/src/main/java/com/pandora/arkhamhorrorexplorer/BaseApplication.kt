package com.pandora.arkhamhorrorexplorer

import android.app.Application
import com.pandora.arkhamhorrorexplorer.shared.di.initKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}