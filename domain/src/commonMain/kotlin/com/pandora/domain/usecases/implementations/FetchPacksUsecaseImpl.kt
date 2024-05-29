package com.pandora.domain.usecases.implementations

import com.pandora.domain.model.Pack
import com.pandora.domain.repositories.CardsRepository
import com.pandora.domain.usecases.FetchPacksUsecase
import kotlinx.coroutines.flow.Flow

internal class FetchPacksUsecaseImpl(private val cardsRepository: CardsRepository): FetchPacksUsecase {
    override fun invoke(): Flow<List<Pack>> = cardsRepository.fetchPacks()
}