package com.applecompose.weatherapp.domain.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.data.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
	private val api: WeatherApi
) {
	suspend fun getWeather(lat: Double, lon: Double): DataOrException<Weather, Boolean, Exception> {
		val response = try {
			api.getWeather(lat.toString(), lon.toString())

		}catch (e: Exception){
			Log.d(TAG, "getWeather: $e")
			return DataOrException(e = e)
		}
		return DataOrException(data = response)



	}
}