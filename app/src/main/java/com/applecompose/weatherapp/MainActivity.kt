package com.applecompose.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.applecompose.weatherapp.navigation.navigation.WeatherNavigation
import com.applecompose.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			WeatherAppTheme {
				WeatherApp()
			}
		}
	}
}

@Composable
fun WeatherApp() {
	// A surface container using the 'background' color from the theme
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colors.background
	) {
		Column(
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.CenterHorizontally
			) {
			WeatherNavigation()

		}


	}

}