package com.pandora.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandora.designsystem.components.LeftImageDescriptionCard
import com.pandora.designsystem.components.Loading
import com.pandora.home.model.Pack
import com.pandora.home.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinInject()
) {
    val coroutineScope = rememberCoroutineScope()

    val packs = rememberSaveable {
        mutableStateOf(emptyList<Pack>())
    }

    LaunchedEffect(true) {
        coroutineScope.launch {
            homeViewModel.packs.collectLatest {
                packs.value = it
            }
        }
        homeViewModel.fetchPacks()
    }

    if (packs.value.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Loading()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(packs.value) {
                LeftImageDescriptionCard(
                    //TODO - Add placeholder as fallback image
                    url = it.imageUrl ?: "",
                    it.name
                )
            }
        }
    }
}