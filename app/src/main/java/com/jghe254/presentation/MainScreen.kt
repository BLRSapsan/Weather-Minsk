package com.jghe254.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jghe254.R
import com.jghe254.data.model.DataResponse
import com.jghe254.presentation.components.DownloadImages
import com.jghe254.presentation.components.ItemText
import com.jghe254.presentation.components.MainScreenAnimation

@Composable
fun MainScreen(dataResponse: DataResponse, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ItemText(
            label = stringResource(id = R.string.city),
            value = dataResponse.name,
            signature = null
        )
        ItemText(
            label = stringResource(id = R.string.temp),
            value = dataResponse.main.temp.toString(),
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.temp_feels_like),
            value = dataResponse.main.feels_like.toString(),
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.pressure),
            value = dataResponse.main.pressure.toString(),
            signature = stringResource(id = R.string.unit_pressure)
        )
        ItemText(
            label = stringResource(id = R.string.humidity),
            value = dataResponse.main.humidity.toString(),
            signature = stringResource(id = R.string.unit_humidity)
        )
        ItemText(
            label = stringResource(id = R.string.speed),
            value = dataResponse.wind.speed.toString(),
            signature = stringResource(id = R.string.unit_speed)
        )
        ItemText(
            label = stringResource(id = R.string.description),
            value = dataResponse.weather[0].description,
            signature = null
        )
        DownloadImages(icon = dataResponse.weather[0].icon)
        MainScreenAnimation(modifier = modifier)
    }
}