package com.applecompose.weatherapp.navigation.screen

sealed class Screen(val route: String) {

	object MainScreen: Screen("main_screen")
	object AboutScreen: Screen("about_screen")
	object FavoritesScreen: Screen("favorites_screen")
	object SearchScreen: Screen("search_screen")
	object SettingsScreen: Screen("settings_screen")
}
