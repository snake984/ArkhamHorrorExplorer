package com.pandora.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val code: String? = null,
    val name: String? = null,
    val text: String? = null,
    val url: String? = null,
    @SerialName("imagesrc") val frontImage: String?= null,
    @SerialName("backimagesrc") val backImage: String? = null
)