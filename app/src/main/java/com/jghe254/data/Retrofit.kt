package com.jghe254.data

import com.jghe254.data.model.DataResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private fun getRetrofit() =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

fun getApi(): Api = getRetrofit().create(Api::class.java)


interface Api {
    @GET("weather?lat=53.9024716&lon=27.5618225&units=metric&lang=ru&appid=01961706473c394e486cc0d57a350cd2")
    suspend fun getApiResponse(): DataResponse
}