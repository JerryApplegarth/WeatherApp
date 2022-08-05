package com.applecompose.weatherapp.presentation.screens.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.presentation.components.widgets.WeatherAppBar

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
	val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
		initialValue = DataOrException(loading = true)
	) {
		value = mainViewModel.getWeatherData(42.232, -123.342)
	}.value

	if (weatherData.loading == true) {
		CircularProgressIndicator()

	} else if (weatherData.data != null) {
		MainScaffold(weather = weatherData.data!!, navController = navController)
	}
}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {
	Scaffold(
		topBar = {
		WeatherAppBar(
			title = "Weather Location: ${weather.lat}, ${weather.lon}",

			navController = navController,
			elevation = 6.dp,
			){

		}
	}
	) {
		MainContent(data = weather)
	}
}

@Composable
fun MainContent(data: Weather) {
	Column() {
		Text(text = data.lat.toString())
		Text(text = data.lon.toString())
	}


}

//Text(text = "Main Screen: lat: ${weatherData.data!!.lat}, lon: ${weatherData.data!!.lon}")
//Spacer(modifier = Modifier.height(16.dp))
//Text(text = "Main Screen: lat: ${weatherData.data!!}")