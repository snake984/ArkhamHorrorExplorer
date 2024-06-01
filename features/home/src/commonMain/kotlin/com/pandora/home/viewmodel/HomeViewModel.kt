package com.pandora.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandora.domain.usecases.FetchCardsUsecase
import com.pandora.domain.usecases.FetchPacksUsecase
import com.pandora.home.model.Pack
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val fetchPacksUsecase: FetchPacksUsecase,
    private val fetchCardsUsecase: FetchCardsUsecase,
    private val backgroundCoroutineContext: CoroutineContext
) : ViewModel() {

    private val _packs = MutableStateFlow<List<Pack>>(emptyList())
    val packs: StateFlow<List<Pack>> = _packs

    private val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?> = _error

    fun fetchPacks() {
        viewModelScope.launch(backgroundCoroutineContext) {
            fetchPacksUsecase()
                .catch { _error.value = it }
                .collectLatest {
                    it.map {
                        val firstCard = fetchCardsUsecase(it.code)
                            .catch { _error.value = it }
                            .firstOrNull()
                            ?.firstOrNull()

                        val computedPack = Pack(
                            name = it.name,
                            code = it.code,
                            cardCount = it.cardCount,
                            available = it.available,
                            imageUrl = firstCard?.frontImage,
                        )

                        _packs.value += computedPack
                    }
                }
        }
    }

    fun resetError() {
        _error.value = null
    }
}