package com.pandora.domain.repositories

import com.pandora.domain.model.Card
import com.pandora.domain.model.Pack
import kotlinx.coroutines.flow.Flow

interface CardsRepository {
    fun fetchPacks(): Flow<List<Pack>>
    fun fetchCards(packCode: String): Flow<List<Card>>
}