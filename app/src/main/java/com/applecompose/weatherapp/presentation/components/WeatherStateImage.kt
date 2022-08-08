package com.applecompose.weatherapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun WeatherStateImage(imageUrl: String) {
	Image(
		painter = rememberImagePainter(imageUrl),
		contentDescription = "Icon Image",
		modifier = Modifier.size(80.dp)
	)

}
@Composable
fun WeatherStateImageSmall(imageUrl: String) {
	Image(
		painter = rememberImagePainter(imageUrl),
		contentDescription = "Icon Image",
		modifier = Modifier.size(60.dp)
	)

}