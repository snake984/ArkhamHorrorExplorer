package com.pandora.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val code: String,
    val name: String,
    val text: String,
    val url: String,
    @SerialName("imagesrc") val frontImage: String,
    @SerialName("backimagesrc") val backImage: String
)