package com.applecompose.weatherapp.presentation.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applecompose.weatherapp.data.DataOrException
import com.applecompose.weatherapp.data.model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel) {

	Column(
				modifier = Modifier
					.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Top
				)

			{
				TopAppBar(modifier = Modifier.fillMaxWidth()) {
					Text(text = "Top App Bar",
						fontSize = 16.sp
						)

				}
				Text(
					text = "Gold Prices",
					fontSize = 24.sp,
					)
				Spacer(modifier = Modifier.height(16.dp))
				Divider(thickness = 2.dp, color = MaterialTheme.colors.primaryVariant)
				Button(
					onClick = {  }) {
					Text(text = "Save")

				}
				ShowData(mainViewModel)
			}


}

@Composable
fun ShowData(mainViewModel: MainViewModel) {

	val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
		initialValue = DataOrException(loading = true)) {
		value = mainViewModel.getWeatherData(42.44, -123.44)
	}.value

	if (weatherData.loading == true) {
		CircularProgressIndicator()

	}else if (weatherData.data != null) {
		Text(text = "Main Screen: lat: ${weatherData.data!!.lat}, lon: ${weatherData.data!!.lon}")
	}


}