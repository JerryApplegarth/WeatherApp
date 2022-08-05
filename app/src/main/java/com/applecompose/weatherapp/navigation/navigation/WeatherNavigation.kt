package com.applecompose.weatherapp.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.applecompose.weatherapp.navigation.screen.Screen
import com.applecompose.weatherapp.presentation.screens.about.AboutScreen
import com.applecompose.weatherapp.presentation.screens.favorites.FavoritesScreen
import com.applecompose.weatherapp.presentation.screens.main.MainScreen
import com.applecompose.weatherapp.presentation.screens.main.MainViewModel
import com.applecompose.weatherapp.presentation.screens.search.SearchScreen
import com.applecompose.weatherapp.presentation.screens.settings.SettingsScreen

@Composable
fun WeatherNavigation() {
	val navController = rememberNavController()
	NavHost(
		navController = navController,
		startDestination = Screen.MainScreen.route) {

		composable(Screen.MainScreen.route) {
			val mainViewModel = hiltViewModel<MainViewModel>()
			MainScreen(navController = navController, mainViewModel = hiltViewModel())
		}
		composable(Screen.AboutScreen.route) {
			AboutScreen(navController = navController)
		}
		composable(Screen.FavoritesScreen.route) {
			FavoritesScreen(navController = navController)
		}
		composable(Screen.SearchScreen.route) {
			SearchScreen(navController = navController)
		}
		composable(Screen.SettingsScreen.route) {
			SettingsScreen(navController = navController)
		}
	}
}