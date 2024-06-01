package com.pandora.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pandora.designsystem.components.LeftImageDescriptionCard
import com.pandora.designsystem.components.Loading
import com.pandora.home.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinInject()
) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        coroutineScope.launch {
            homeViewModel.fetchPacks()
        }
    }

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        HomeContent(modifier, homeViewModel) {
            coroutineScope.launch {
                homeViewModel.resetError()
                homeViewModel.fetchPacks()
            }
        }
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    onRetry: () -> Unit = {}
) {
    val packs by homeViewModel.packs.collectAsState()
    val error by homeViewModel.error.collectAsState()

    if (packs.isNotEmpty() && error == null) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(packs) {
                LeftImageDescriptionCard(
                    //TODO - Add placeholder as fallback image
                    url = it.imageUrl ?: "",
                    it.name
                )
            }
        }

    } else if (packs.isEmpty() && error != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center,
                    text = "An error happened while loading packs. Please retry.",
                    color = MaterialTheme.colorScheme.onSurface
                )
                Button(onClick = { onRetry() }) {
                    Text("Retry")
                }
            }
        }
    } else if (packs.isEmpty() && error == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Loading()
        }
    }
}