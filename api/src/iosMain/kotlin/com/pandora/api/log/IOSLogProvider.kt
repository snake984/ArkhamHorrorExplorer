package com.pandora.api.log

actual val platformLogProvider: LogProvider = IOSLogProvider()
internal class IOSLogProvider: LogProvider {
    override fun debug(tag: String?, message: String) {
        //TODO
    }
}