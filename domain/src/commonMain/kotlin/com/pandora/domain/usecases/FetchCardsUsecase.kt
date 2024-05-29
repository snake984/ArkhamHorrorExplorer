package com.pandora.domain.usecases

import com.pandora.domain.model.Card
import com.pandora.domain.model.Pack
import kotlinx.coroutines.flow.Flow

interface FetchCardsUsecase {
    operator fun invoke(packCode: String): Flow<List<Card>>
}