package com.pandora.api.log

actual val platformLogProvider: LogProvider = JvmLogProvider()
internal class JvmLogProvider: LogProvider {
    override fun debug(tag: String?, message: String) {
        //TODO
    }
}