package com.weatherMinsk.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.weatherMinsk.R
import com.weatherMinsk.domain.model.DataDomain
import com.weatherMinsk.presentation.components.DownloadImages
import com.weatherMinsk.presentation.components.ItemText
import com.weatherMinsk.presentation.components.MainScreenAnimation

@Composable
fun MainScreen(dataDomain: DataDomain, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ItemText(
            label = stringResource(id = R.string.city),
            value = dataDomain.name,
            signature = null
        )
        ItemText(
            label = stringResource(id = R.string.temp),
            value = dataDomain.temp,
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.temp_feels_like),
            value = dataDomain.feels_like,
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.pressure),
            value = dataDomain.pressure,
            signature = stringResource(id = R.string.unit_pressure)
        )
        ItemText(
            label = stringResource(id = R.string.humidity),
            value = dataDomain.humidity,
            signature = stringResource(id = R.string.unit_humidity)
        )
        ItemText(
            label = stringResource(id = R.string.speed),
            value = dataDomain.speed,
            signature = stringResource(id = R.string.unit_speed)
        )
        ItemText(
            label = stringResource(id = R.string.description),
            value = dataDomain.description,
            signature = null
        )
        DownloadImages(icon = dataDomain.icon)
        MainScreenAnimation(modifier = modifier)
    }
}