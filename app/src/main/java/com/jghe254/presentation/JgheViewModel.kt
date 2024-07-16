package com.jghe254.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jghe254.data.toDomain
import com.jghe254.domain.Repository
import com.jghe254.domain.model.DomainResponse
import kotlinx.coroutines.launch

sealed interface JgheUIState {
    data class List(val domainResponse: DomainResponse) : JgheUIState
    data object Loading : JgheUIState
    data object Error : JgheUIState
}

class JgheViewModel(private val repository: Repository) : ViewModel() {
    var mutableJgheUIState: JgheUIState by mutableStateOf(JgheUIState.Loading)
        private set

    init {
        getResponse()
    }

    fun getResponse() {
        viewModelScope.launch {
            mutableJgheUIState = JgheUIState.Loading
            val result = repository.getResponse()
            result.fold(
                onSuccess = { data ->
                    mutableJgheUIState = JgheUIState.List(domainResponse = data.toDomain())
                },
                onFailure = { mutableJgheUIState = JgheUIState.Error })
        }
    }
}