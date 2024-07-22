package com.weatherMinsk.data

import com.weatherMinsk.data.model.WeatherResponse

interface DataSource {
    suspend fun getResponse(): Result<WeatherResponse>
}