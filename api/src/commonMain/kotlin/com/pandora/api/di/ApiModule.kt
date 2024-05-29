package com.pandora.api.di

import com.pandora.api.client.ApiClient
import com.pandora.api.client.ArkhamDBApiClient
import com.pandora.api.log.platformLogProvider
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val apiModule = module {
    singleOf(::ArkhamDBApiClient) bind ApiClient::class
    single<HttpClient> {
        HttpClient {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        platformLogProvider.debug(message = message)
                    }
                }
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    })
            }
        }
    }
}