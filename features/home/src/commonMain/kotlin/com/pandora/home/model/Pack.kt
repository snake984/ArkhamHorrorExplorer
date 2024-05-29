package com.pandora.home.model

import androidx.compose.runtime.Immutable
import com.pandora.parcelable.CommonParcelable
import com.pandora.parcelable.CommonParcelize

@Immutable
@CommonParcelize
data class Pack(
    val name: String,
    val code: String,
    val cardCount: Int,
    val available: String,
    val imageUrl: String? = null,
): CommonParcelable
