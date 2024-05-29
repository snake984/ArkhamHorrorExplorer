package com.pandora.api.log

expect val platformLogProvider: LogProvider
interface LogProvider {
    fun debug(tag: String? = null, message: String)
}