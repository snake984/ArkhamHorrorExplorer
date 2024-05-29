package com.pandora.repositories.implementation

import com.pandora.api.client.ApiClient
import com.pandora.domain.model.Card
import com.pandora.domain.model.Pack
import com.pandora.domain.repositories.CardsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class CardsRepositoryImpl(private val apiClient: ApiClient) : CardsRepository {
    override fun fetchPacks(): Flow<List<Pack>> {
        return flow {
            emit(apiClient.fetchPacks().map {
                Pack(
                    name = it.name,
                    cardCount = it.cardCount,
                    code = it.code,
                    available = it.available,
                    url = it.url,
                )
            })
        }
    }

    override fun fetchCards(packCode: String): Flow<List<Card>> {
        return flow {
            emit(apiClient.fetchCards(packCode)
                .filter { it.code != null && it.name != null && it.url != null }
                .map {
                Card(
                    code = it.code ?: throw IllegalStateException("Card code is not allowed to be null"),
                    name = it.name ?: throw IllegalStateException("Card name is not allowed to be null"),
                    text = it.text,
                    url = it.url ?: throw IllegalStateException("Card url is not allowed to be null"),
                    frontImage = "${apiClient.domainUrl}${it.frontImage}",
                    backImage = "${apiClient.domainUrl}${it.backImage}",
                )
            })
        }
    }
}