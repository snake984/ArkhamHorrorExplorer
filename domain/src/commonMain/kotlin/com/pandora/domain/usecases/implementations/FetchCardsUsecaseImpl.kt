package com.pandora.domain.usecases.implementations

import com.pandora.domain.model.Card
import com.pandora.domain.repositories.CardsRepository
import com.pandora.domain.usecases.FetchCardsUsecase
import kotlinx.coroutines.flow.Flow

internal class FetchCardsUsecaseImpl(private val cardsRepository: CardsRepository): FetchCardsUsecase {
    override fun invoke(packCode: String): Flow<List<Card>> = cardsRepository.fetchCards(packCode)

}