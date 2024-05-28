package com.pandora.arkhamhorrorexplorer

import android.app.Application
import com.pandora.arkhamhorrorexplorer.shared.di.initKoin
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(appModule = module {
            single<CoroutineContext> {
                Dispatchers.Default
            }
        })
    }
}