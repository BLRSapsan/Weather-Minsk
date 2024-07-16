package com.jghe254.data

import com.jghe254.data.model.DataResponse
import com.jghe254.domain.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL =
    "https://api.openweathermap.org/data/2.5/"

class RepositoryImpl(private val api: Api) : Repository {
    override suspend fun getResponse(): Result<DataResponse> {
        return kotlin.runCatching { api.getApiResponse() }
    }
}

private fun getRetrofit() =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

fun getApi(): Api = getRetrofit().create(Api::class.java)

interface Api {
    @GET("weather?lat=53.9024716&lon=27.5618225&units=metric&lang=ru&appid=01961706473c394e486cc0d57a350cd2")
    suspend fun getApiResponse(): DataResponse
}