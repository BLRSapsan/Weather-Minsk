package com.jghe254.presentation

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
import com.jghe254.presentation.ui.theme.Jghe254Theme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jghe254Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    JgheApp()
                }
            }
        }
    }
}

@Composable
fun JgheApp() {
    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val jgheViewModel: JgheViewModel = koinViewModel()
            HomeScreen(
                jgheUIState = jgheViewModel.mutableJgheUIState,
                retryAction = jgheViewModel::getResponse
            )
        }
    }
}