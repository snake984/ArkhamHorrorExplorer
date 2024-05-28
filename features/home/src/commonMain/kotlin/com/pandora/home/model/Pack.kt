package com.pandora.home.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pack(
    val name: String,
    val code: String,
    val available: String,
    val url: String,
)
