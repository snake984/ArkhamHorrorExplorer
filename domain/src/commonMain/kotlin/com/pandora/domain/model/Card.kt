package com.pandora.domain.model

data class Card(
    val code: String,
    val name: String,
    val text: String,
    val url: String,
    val frontImage: String,
    val backImage: String
)