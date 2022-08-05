package com.applecompose.weatherapp.data.model

data class WeatherItem(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val uvi: Int,
    val visibility: Int,
    val weather: List<WeatherObject>,
    val wind_deg: Int,
    val wind_speed: Double
)