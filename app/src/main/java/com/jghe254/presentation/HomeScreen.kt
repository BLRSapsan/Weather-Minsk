package com.jghe254.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    jgheUIState: JgheUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (jgheUIState) {
        is JgheUIState.Loading -> LoadingScreen(modifier = modifier)
        is JgheUIState.Error -> ErrorScreen(retryAction = retryAction, modifier = modifier)
        is JgheUIState.List -> MainScreen(
            domainResponse = jgheUIState.domainResponse,
            modifier = modifier
        )
    }
}
