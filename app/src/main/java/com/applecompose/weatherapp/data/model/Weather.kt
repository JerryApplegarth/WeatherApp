package com.applecompose.weatherapp.data.model

data class Weather(
    val current: WeatherItem,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)