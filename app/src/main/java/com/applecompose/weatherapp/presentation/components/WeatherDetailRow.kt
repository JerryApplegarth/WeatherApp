package com.applecompose.weatherapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.applecompose.weatherapp.data.model.Daily
import com.applecompose.weatherapp.presentation.utils.formatDate
import com.applecompose.weatherapp.presentation.utils.formatDecimals

@Composable
fun WeatherDetailRow(dailyItem: Daily) {
	val imageUrl = "https://openweathermap.org/img/wn/${dailyItem.weather[0].icon}.png"

	Surface(
		modifier = Modifier
			.padding(3.dp)
			.fillMaxWidth(),
		shape = CircleShape.copy(CornerSize(6.dp)),
		color = MaterialTheme.colors.background
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				formatDate(dailyItem.dt)
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
			Text(text = buildAnnotatedString {
				withStyle(
					style = SpanStyle(
						color = MaterialTheme.colors.secondary,
						fontWeight = FontWeight.SemiBold
					)
				) {
					append(formatDecimals(dailyItem.temp.max) + "°")
				}
				withStyle(
					style = SpanStyle(
						color = Color.DarkGray,

						)
				) {
					append(formatDecimals(dailyItem.temp.min) + "°")
				}



			})


		}

	}

}

