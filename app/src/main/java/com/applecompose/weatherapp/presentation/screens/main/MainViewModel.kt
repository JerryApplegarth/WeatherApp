package com.applecompose.weatherapp.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: WeatherRepository
):ViewModel()  {

	suspend fun getWeatherData(lat: Double, lon: Double): DataOrException<Weather, Boolean, Exception> {
		return repository.getWeather(lat, lon)
	}






}