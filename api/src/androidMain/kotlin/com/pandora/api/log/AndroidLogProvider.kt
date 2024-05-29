package com.pandora.api.log

import android.util.Log

actual val platformLogProvider: LogProvider = AndroidLogProvider()
internal class AndroidLogProvider: LogProvider {
    override fun debug(tag: String?, message: String) {
        Log.d(tag, message)
    }
}