package com.pandora.api.di

import com.pandora.api.client.ApiClient
import com.pandora.api.client.ArkhamDBApiClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {
    singleOf(::ArkhamDBApiClient) bind ApiClient::class
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    })
            }
        }
    }
}