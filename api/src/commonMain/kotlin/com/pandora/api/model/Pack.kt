package com.pandora.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pack(
    val name: String,
    val code: String,
    @SerialName("total") val cardCount: Int,
    val available: String,
    val url: String,
)