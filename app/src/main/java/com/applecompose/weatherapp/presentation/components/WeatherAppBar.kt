package com.applecompose.weatherapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.applecompose.weatherapp.R

@Composable
fun WeatherAppBar(
	title: String,
	icon: ImageVector? = null,
	isMainScreen: Boolean = true,
	elevation: Dp = 0.dp,
	navController: NavController,
	onAddActionClicked: () -> Unit = {},
	onButtonClicked: () -> Unit = {},

	) {
	TopAppBar(
		title = {
			Text(
				text = title,
				color = MaterialTheme.colors.onPrimary,
				style = TextStyle(
					fontWeight = FontWeight.Bold,
					fontSize = 20.sp
					)
			)
		},
		actions = {
			if (isMainScreen) {
				IconButton(onClick = { /*TODO*/ }) {
					Icon(
						imageVector = Icons.Default.Search,
						contentDescription = stringResource(R.string.search_icon),
					)
				}
				Icon(
					imageVector = Icons.Rounded.MoreVert,
					contentDescription = stringResource(R.string.moore_icon),
				)
			} else Box {}
		},
		navigationIcon = {
						 if (icon != null) {
							 Icon(
								 imageVector = Icons.Default.ArrowBack,
								 contentDescription = stringResource(R.string.back_arrow_icon),
							    tint = MaterialTheme.colors.onPrimary,
								 modifier = Modifier
									 .clickable {
										 onButtonClicked.invoke()
									 }
								 )
						 }
		},
		backgroundColor = MaterialTheme.colors.primary,
		elevation = elevation
	)


}