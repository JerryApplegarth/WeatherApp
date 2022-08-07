package com.applecompose.weatherapp.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Daily
import com.applecompose.weatherapp.data.model.Weather
import com.applecompose.weatherapp.presentation.components.HumidityWindPressureRow
import com.applecompose.weatherapp.presentation.components.SunriseSunset
import com.applecompose.weatherapp.presentation.components.WeatherAppBar
import com.applecompose.weatherapp.presentation.components.WeatherStateImage
import com.applecompose.weatherapp.presentation.utils.formatDate
import com.applecompose.weatherapp.presentation.utils.formatDecimals
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
			) {

			}
		}
	) {
		MainContent(data = weather)
	}
}

@Composable
fun MainContent(data: Weather) {
	val weatherItem = data.current
	val imageUrl = "https://openweathermap.org/img/wn/${weatherItem.weather[0].icon}.png"
	val dailyItem = data.daily


	Column(
		modifier = Modifier
			.padding(4.dp)
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {

		Text(
			text = formatDate(weatherItem.dt),
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
				WeatherStateImage(imageUrl = imageUrl)

				Text(
					text = formatDecimals(weatherItem.temp) + "°",
					style = MaterialTheme.typography.h4,
					fontWeight = FontWeight.ExtraBold,
					fontSize = 36.sp
				)
				Text(
					text = data.current.weather[0].description,

					fontStyle = FontStyle.Italic,
					fontWeight = FontWeight.ExtraBold,
					fontSize = 20.sp
				)

			}

		}
		HumidityWindPressureRow(weather = weatherItem)
		Divider()
		SunriseSunset(weather = weatherItem)
		Divider()
		Text(
			text = "This Week",
			style = MaterialTheme.typography.subtitle1,
			fontWeight = FontWeight.Bold
			)
		Surface(
			modifier = Modifier
				.fillMaxSize(),
			color = MaterialTheme.colors.secondary,
			shape = RoundedCornerShape(16.dp)
			) {
			LazyColumn(
				modifier = Modifier
					.padding(2.dp),
				contentPadding = PaddingValues(1.dp)
			){
				items(items = data.daily) {
					item: Daily ->
					//Text(item.temp.max.toString())
					WeatherDetailRow(dailyItem = item)
				}

			}

		}

	}
}

@Composable
fun WeatherDetailRow(dailyItem: Daily) {
	val imageUrl = "https://openweathermap.org/img/wn/${dailyItem.weather[0].icon}.png"
	
	Surface(
		modifier = Modifier
			.padding(3.dp)
			.fillMaxWidth(),
		shape = CircleShape,
		color = MaterialTheme.colors.secondary
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(formatDate(dailyItem.dt)
				.split(",")[0],
				modifier = Modifier
					.padding(start = 6.dp)
				)
			WeatherStateImage(imageUrl = imageUrl)
			Surface(
				modifier = Modifier
					.padding(0.dp),
				shape = CircleShape,
				color = MaterialTheme.colors.primary
			) {
				Text(dailyItem.weather[0].description)

			}
			

		}

	}

	}










	







