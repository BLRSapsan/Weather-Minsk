package com.jghe254.data

import com.jghe254.data.model.DataResponse

interface DataSource {
    suspend fun getResponse(): Result<DataResponse>
}