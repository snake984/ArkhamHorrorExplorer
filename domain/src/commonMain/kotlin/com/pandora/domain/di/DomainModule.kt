package com.pandora.domain.di

import com.pandora.domain.usecases.FetchPacksUsecase
import com.pandora.domain.usecases.implementations.FetchPacksUsecaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::FetchPacksUsecaseImpl) bind FetchPacksUsecase::class
}