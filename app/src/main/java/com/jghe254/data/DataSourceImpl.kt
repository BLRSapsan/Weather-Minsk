package com.jghe254.data

import com.jghe254.data.model.DataResponse

class DataSourceImpl(private val api: Api):DataSource {
    override suspend fun getResponse(): Result<DataResponse> {
        return kotlin.runCatching { api.getApiResponse() }
    }
}