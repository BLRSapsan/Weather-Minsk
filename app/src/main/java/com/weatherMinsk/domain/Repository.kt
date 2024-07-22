package com.weatherMinsk.domain

import com.weatherMinsk.data.model.WeatherResponse

interface Repository {
    suspend fun getResponse():Result<WeatherResponse>
}