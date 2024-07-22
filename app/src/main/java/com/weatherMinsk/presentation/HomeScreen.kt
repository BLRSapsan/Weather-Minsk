package com.weatherMinsk.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    weatherUIState: WeatherUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (weatherUIState) {
        is WeatherUIState.Loading -> LoadingScreen(modifier = modifier)
        is WeatherUIState.Error -> ErrorScreen(retryAction = retryAction, modifier = modifier)
        is WeatherUIState.List -> MainScreen(
            dataDomain = weatherUIState.dataDomain,
            modifier = modifier
        )
    }
}
