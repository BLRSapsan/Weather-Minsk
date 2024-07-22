package com.weatherMinsk.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherMinsk.data.toDomain
import com.weatherMinsk.domain.Repository
import com.weatherMinsk.domain.model.DataDomain
import kotlinx.coroutines.launch

sealed interface WeatherUIState {
    data class List(val dataDomain: DataDomain) : WeatherUIState
    data object Loading : WeatherUIState
    data object Error : WeatherUIState
}

class WeatherViewModel(private val repository: Repository) : ViewModel() {
    var mutableWeatherUIState: WeatherUIState by mutableStateOf(WeatherUIState.Loading)
        private set

    init {
        getResponse()
    }

    fun getResponse() {
        viewModelScope.launch {
            mutableWeatherUIState = WeatherUIState.Loading
            val result = repository.getResponse()
            result.fold(
                onSuccess = { data ->
                    mutableWeatherUIState = WeatherUIState.List(dataDomain = data.toDomain())
                },
                onFailure = { mutableWeatherUIState = WeatherUIState.Error })
        }
    }
}