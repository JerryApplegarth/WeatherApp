package com.applecompose.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applecompose.weatherapp.R
import com.applecompose.weatherapp.data.model.WeatherItem
import com.applecompose.weatherapp.presentation.utils.formatDateTime

@Composable
fun SunriseSunset(weather: WeatherItem) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 15.dp, bottom = 6.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Row (modifier = Modifier.padding(start = 16.dp)){
			Image(

				painter = painterResource(id = R.drawable.sunrise),
				contentDescription = "sunrise icon",
				modifier = Modifier.size(30.dp),

				)
			Text(
				text = formatDateTime(weather.sunrise),
				style = MaterialTheme.typography.caption

			)
		}
		Row(modifier = Modifier.padding(end = 6.dp)) {
			Image(

				painter = painterResource(id = R.drawable.sunset),
				contentDescription = "sunset icon",
				modifier = Modifier.size(30.dp),

				)
			Text(
				text = formatDateTime(weather.humidity),
				style = MaterialTheme.typography.caption
			)


		}

	}

}
