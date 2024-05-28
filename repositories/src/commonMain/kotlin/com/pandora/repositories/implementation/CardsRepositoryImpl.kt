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
                    code = it.code,
                    available = it.available,
                    url = it.url,
                )
            })
        }
    }

    override fun fetchCards(packCode: String): Flow<List<Card>> {
        return flow {
            emit(apiClient.fetchCards(packCode).map {
                Card(
                    code = it.code,
                    name = it.name,
                    text = it.text,
                    url = it.url,
                    frontImage = it.frontImage,
                    backImage = it.backImage,
                )
            })
        }
    }
}