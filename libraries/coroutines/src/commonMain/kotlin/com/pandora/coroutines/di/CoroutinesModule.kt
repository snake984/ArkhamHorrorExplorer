package com.pandora.coroutines.di

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

const val BACKGROUND_COROUTINE_CONTEXT = "background_coroutine_context_di_name"
val coroutinesModule = module {
    single<CoroutineContext>(named(BACKGROUND_COROUTINE_CONTEXT)) { Dispatchers.IO }
}