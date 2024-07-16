package com.jghe254.domain

import com.jghe254.data.model.DataResponse

interface Repository {
    suspend fun getResponse():Result<DataResponse>
}