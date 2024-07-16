package com.jghe254.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jghe254.R
import com.jghe254.domain.model.DomainResponse
import com.jghe254.presentation.components.DownloadImages
import com.jghe254.presentation.components.ItemText
import com.jghe254.presentation.components.MainScreenAnimation

@Composable
fun MainScreen(domainResponse: DomainResponse, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        ItemText(
            label = stringResource(id = R.string.city),
            value = domainResponse.name,
            signature = null
        )
        ItemText(
            label = stringResource(id = R.string.temp),
            value = domainResponse.temp,
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.temp_feels_like),
            value = domainResponse.feels_like,
            signature = stringResource(
                id = R.string.celsius
            )
        )
        ItemText(
            label = stringResource(id = R.string.pressure),
            value = domainResponse.pressure,
            signature = stringResource(id = R.string.unit_pressure)
        )
        ItemText(
            label = stringResource(id = R.string.humidity),
            value = domainResponse.humidity,
            signature = stringResource(id = R.string.unit_humidity)
        )
        ItemText(
            label = stringResource(id = R.string.speed),
            value = domainResponse.speed,
            signature = stringResource(id = R.string.unit_speed)
        )
        ItemText(
            label = stringResource(id = R.string.description),
            value = domainResponse.description,
            signature = null
        )
        DownloadImages(icon = domainResponse.icon)
        MainScreenAnimation(modifier = modifier)
    }
}