package com.pandora.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Pack(
    val name: String,
    val code: String,
    val available: String,
    val url: String,
)