package com.jghe254.data

import com.jghe254.data.model.DataResponse
import com.jghe254.domain.Repository
import com.jghe254.domain.model.DomainResponse

const val BASE_URL =
    "https://api.openweathermap.org/data/2.5/"

class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getResponse(): Result<DataResponse> {
        return dataSource.getResponse()
    }
}

fun DataResponse.toDomain() = DomainResponse(
    name = name,
    temp = main.temp.toString(),
    feels_like = main.feels_like.toString(),
    pressure = main.pressure.toString(),
    humidity = main.humidity.toString(),
    speed = wind.speed.toString(),
    description = weather[0].description,
    icon = weather[0].icon
)