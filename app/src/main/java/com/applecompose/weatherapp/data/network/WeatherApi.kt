package com.applecompose.weatherapp.data.network

import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.presentation.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

	@GET(value = "data/3.0/onecall?lat=43.23&lon=-123.32&appid=0591da9bc5afc7d4ba5f0232b164cb3f")
	suspend fun getWeather(
		@Query("lat") lat: String = Constants.LAT,
		@Query("lon") lon: String = Constants.LON,
		@Query("appid") appid: String = Constants.API_KEY
	): Weather



}

/*
https://api.openweathermap.org/data/3.0/onecall?lat=43.23&lon=-123.32&appid=0591da9bc5afc7d4ba5f0232b164cb3f
 */