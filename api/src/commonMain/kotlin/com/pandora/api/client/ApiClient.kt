package com.pandora.api.client

import com.pandora.api.model.Card
import com.pandora.api.model.Pack
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface ApiClient {
    val baseUrl: String

    suspend fun fetchPacks(): List<Pack>
    suspend fun fetchCards(packCode: String): List<Card>
}

internal class ArkhamDBApiClient(private val httpClient: HttpClient) : ApiClient {

    override val baseUrl: String
        get() = "https://arkhamdb.com/api/public"

    override suspend fun fetchPacks(): List<Pack> {
        return httpClient.get("$baseUrl/packs/").body()
    }

    override suspend fun fetchCards(packCode: String): List<Card> {
        return httpClient.get("$baseUrl/cards/$packCode.json").body()
    }
}