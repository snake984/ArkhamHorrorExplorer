package com.pandora.arkhamhorrorexplorer.shared.di

import com.pandora.api.di.apiModule
import com.pandora.domain.di.domainModule
import com.pandora.home.di.homeModule
import com.pandora.repositories.di.repositoriesModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module = module { }) {
    startKoin {
        modules(appModules + appModule)
    }
}

internal val appModules = listOf(
    homeModule,
    apiModule,
    repositoriesModule,
    domainModule,
)