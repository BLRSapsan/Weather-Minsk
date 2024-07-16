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

fun DataResponse.toDomain(dataResponse: DataResponse) = DomainResponse(
    name = dataResponse.name,
    temp = dataResponse.main.temp.toString(),
    feels_like = dataResponse.main.feels_like.toString(),
    pressure = dataResponse.main.pressure.toString(),
    humidity = dataResponse.main.humidity.toString(),
    speed = dataResponse.wind.speed.toString(),
    description = dataResponse.weather[0].description,
    icon = dataResponse.weather[0].icon
)