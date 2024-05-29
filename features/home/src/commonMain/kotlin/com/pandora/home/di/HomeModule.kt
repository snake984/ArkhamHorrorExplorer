package com.pandora.home.di

import com.pandora.coroutines.di.BACKGROUND_COROUTINE_CONTEXT
import com.pandora.home.viewmodel.HomeViewModel
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val homeModule = module {
    viewModelDefinition {
        HomeViewModel(get(), get(), get(named(BACKGROUND_COROUTINE_CONTEXT)))
    }
}