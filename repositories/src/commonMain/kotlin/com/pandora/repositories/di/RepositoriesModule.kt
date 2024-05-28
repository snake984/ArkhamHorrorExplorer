package com.pandora.repositories.di

import com.pandora.domain.repositories.CardsRepository
import com.pandora.repositories.implementation.CardsRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoriesModule = module {
    singleOf(::CardsRepositoryImpl) bind CardsRepository::class
}