package com.pandora

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.pandora.arkhamhorrorexplorer.shared.MultiplatformViewContainer
import com.pandora.arkhamhorrorexplorer.shared.di.initKoin

fun main() = application {
    val windowState = rememberWindowState()
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "KotlinProject",
    ) {
        MultiplatformViewContainer()
    }
}