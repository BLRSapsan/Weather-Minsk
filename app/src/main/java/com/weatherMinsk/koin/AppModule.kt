package com.weatherMinsk.koin

import com.weatherMinsk.data.Api
import com.weatherMinsk.data.DataSource
import com.weatherMinsk.data.DataSourceImpl
import com.weatherMinsk.data.RepositoryImpl
import com.weatherMinsk.data.getApi
import com.weatherMinsk.domain.Repository
import com.weatherMinsk.presentation.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { WeatherViewModel(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single<DataSource> { DataSourceImpl(get()) }
    single <Api> { getApi() }
}