package com.weatherMinsk.data

import com.weatherMinsk.data.model.WeatherResponse
import com.weatherMinsk.domain.Repository
import com.weatherMinsk.domain.model.DataDomain

class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getResponse(): Result<WeatherResponse> {
        return dataSource.getResponse()
    }
}

fun WeatherResponse.toDomain() = DataDomain(
    name = name,
    temp = main.temp.toString(),
    feels_like = main.feels_like.toString(),
    pressure = main.pressure.toString(),
    humidity = main.humidity.toString(),
    speed = wind.speed.toString(),
    description = weather[0].description,
    icon = weather[0].icon
)