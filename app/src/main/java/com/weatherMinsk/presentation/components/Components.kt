package com.weatherMinsk.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.weatherMinsk.R

@Composable
fun ItemText(label:String, value:String, signature: String?) {
    Row {
        Text(text = label)
        Text(text = value)
        if (signature != null) {
            Text(text = signature)
        }
    }
}

@Composable
fun DownloadImages(icon: String) {
    Box(modifier = Modifier) {
        AsyncImage(
            model = "https://openweathermap.org/img/wn/$icon.png",
            placeholder = painterResource(id = R.drawable.baseline_downloading_24),
            error = null,
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier.size(200.dp)
        )
    }
}