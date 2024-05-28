package com.pandora.home.di

import com.pandora.home.viewmodel.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    viewModelDefinition {
        HomeViewModel(get(), get())
    }
}