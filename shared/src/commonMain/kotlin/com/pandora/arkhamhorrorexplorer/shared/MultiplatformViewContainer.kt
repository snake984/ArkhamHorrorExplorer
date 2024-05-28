package com.pandora.arkhamhorrorexplorer.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pandora.designsystem.ArkhamHorrorExplorerTheme
import com.pandora.home.ui.HomeScreen

@Composable
fun MultiplatformViewContainer(
    modifier: Modifier = Modifier
) {
    ArkhamHorrorExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(modifier)
        }
    }
}