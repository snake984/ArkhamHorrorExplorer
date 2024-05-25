package com.pandora.arkhamhorrorexplorer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform