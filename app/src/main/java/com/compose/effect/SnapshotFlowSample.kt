package com.compose.effect

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@OptIn(FlowPreview::class)
@Composable
fun SnapshotFlowSample() {
    val listState = rememberLazyListState()

    LazyColumn (state = listState){
        items(1000) { Text("Item -> $it") }
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .filter { it > 20 }
            .distinctUntilChanged()
            .debounce(1000)
            .collect { index ->
                println("First visible item index: $index")
            }
    }
}