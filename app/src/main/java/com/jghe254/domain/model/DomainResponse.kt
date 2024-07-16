package com.jghe254.domain.model

data class DomainResponse(
    val name: String,
    val temp: String,
    val feels_like: String,
    val pressure: String,
    val humidity: String,
    val speed: String,
    val description: String,
    val icon:String
)