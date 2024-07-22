package com.weatherMinsk.data

import com.weatherMinsk.data.model.WeatherResponse

class DataSourceImpl(private val api: Api):DataSource {
    override suspend fun getResponse(): Result<WeatherResponse> {
        return kotlin.runCatching { api.getApiResponse() }
    }
}