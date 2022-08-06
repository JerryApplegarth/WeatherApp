package com.applecompose.weatherapp.presentation.screens.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.presentation.components.widgets.WeatherAppBar
import com.applecompose.weatherapp.presentation.utils.formatDate
import com.applecompose.weatherapp.ui.theme.sunColor

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {
	val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
		initialValue = DataOrException(loading = true)
	) {
		value = mainViewModel.getWeatherData(43.23, -123.34)
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

	val imageUrl = "https://openweathermap.org/img/wn/${data.current.weather[0].icon}.png"

	Column(
		modifier = Modifier
			.padding(4.dp)
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Text(
			text = formatDate(data.current.dt),
			style = MaterialTheme.typography.caption,
			color = MaterialTheme.colors.onSecondary,
			fontWeight = FontWeight.SemiBold,
			modifier = Modifier
				.padding(6.dp)
			)
		Surface(
			modifier = Modifier
				.padding(4.dp)
				.size(200.dp),
			shape = CircleShape,
			color = MaterialTheme.colors.sunColor
		) {
			Column(
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally

				) {
				WeatherStateImage(imageUrl = imageUrl )

				Text(
					text = data.current.temp.toString(),
					style = MaterialTheme.typography.h4,
					fontWeight = FontWeight.ExtraBold,
					fontSize = 36.sp
					)
				Text(
					text = "Hot",

					fontStyle = FontStyle.Italic,
					fontWeight = FontWeight.ExtraBold,
					fontSize = 20.sp
					)

			}

		}

	}


}

@Composable
fun WeatherStateImage(imageUrl: String) {
	Image(
		painter = rememberImagePainter(imageUrl),
		contentDescription = "Icon Image",
		modifier = Modifier.size(90.dp)
		)

}

//Text(text = "Main Screen: lat: ${weatherData.data!!.lat}, lon: ${weatherData.data!!.lon}")
//Spacer(modifier = Modifier.height(16.dp))
//Text(text = "Main Screen: lat: ${weatherData.data!!}")