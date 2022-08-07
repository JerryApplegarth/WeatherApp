package com.applecompose.weatherapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.applecompose.weatherapp.R
import com.applecompose.weatherapp.data.model.WeatherItem

@Composable
fun HumidityWindPressureRow(weather: WeatherItem) {
	Row(
		modifier = Modifier
			.padding(12.dp)
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Row(
			modifier = Modifier
				.padding(4.dp)
		) {
			Icon(
				painter = painterResource(id = R.drawable.humidity),
				contentDescription = "humidity icon",
				modifier = Modifier.size(30.dp)
			)
			Text(
				text = "${weather.humidity}%",
				style = MaterialTheme.typography.caption
			)

		}
		Row {

//			Icon(
//				painter = painterResource(id = R.drawable.pressure),
//				contentDescription = "pressure icon",
//				modifier = Modifier.size(30.dp)
//			)
			Text(

				text = "Feels Like: ${weather.feels_like}",
				fontWeight = FontWeight.Bold,
				style = MaterialTheme.typography.caption,

				)

		}
		Row() {
			Icon(
				painter = painterResource(id = R.drawable.wind),
				contentDescription = "wind icon",
				modifier = Modifier.size(30.dp)
			)
			Text(
				text = "${weather.wind_speed} mph",
				style = MaterialTheme.typography.caption
			)

		}

	}

}
