package com.pandora.api

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform