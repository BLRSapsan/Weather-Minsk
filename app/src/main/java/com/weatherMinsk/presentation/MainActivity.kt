package com.weatherMinsk.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.weatherMinsk.presentation.ui.theme.WeatherTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    WeatherApp()
                }
            }
        }
    }
}

@Composable
fun WeatherApp() {
    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val weatherViewModel: WeatherViewModel = koinViewModel()
            HomeScreen(
                weatherUIState = weatherViewModel.mutableWeatherUIState,
                retryAction = weatherViewModel::getResponse
            )
        }
    }
}