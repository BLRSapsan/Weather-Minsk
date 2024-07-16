package com.jghe254.koin

import com.jghe254.data.Api
import com.jghe254.data.RepositoryImpl
import com.jghe254.data.getApi
import com.jghe254.domain.Repository
import com.jghe254.presentation.JgheViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { JgheViewModel(get()) }
    single<Repository> { RepositoryImpl(get()) }
    single <Api> { getApi() }
}