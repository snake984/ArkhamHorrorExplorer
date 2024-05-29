package com.pandora.api.client

import com.pandora.api.model.Card
import com.pandora.api.model.Pack
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface ApiClient {
    val domainUrl: String
    val baseUrl: String

    suspend fun fetchPacks(): List<Pack>
    suspend fun fetchCards(packCode: String): List<Card>
}

internal class ArkhamDBApiClient(private val httpClient: HttpClient) : ApiClient {

    override val domainUrl: String
        get() = "https://arkhamdb.com"

    override val baseUrl: String
        get() = "$domainUrl/api/public"

    override suspend fun fetchPacks(): List<Pack> = httpClient.get("$baseUrl/packs/").body()

    override suspend fun fetchCards(packCode: String): List<Card> =
        httpClient.get("$baseUrl/cards/$packCode.json").body()
}