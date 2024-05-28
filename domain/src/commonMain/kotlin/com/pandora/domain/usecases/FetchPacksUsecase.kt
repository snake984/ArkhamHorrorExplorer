package com.pandora.domain.usecases

import com.pandora.domain.model.Pack
import kotlinx.coroutines.flow.Flow

interface FetchPacksUsecase {
    operator fun invoke(): Flow<List<Pack>>
}