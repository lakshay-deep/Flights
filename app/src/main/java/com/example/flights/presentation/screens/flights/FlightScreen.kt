package com.example.flights.presentation.screens.flights

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.flights.presentation.ui.components.FlightDisplay
import com.example.flights.presentation.ui.components.FlightScreenAppBar
import com.example.flights.presentation.ui.components.Loading
import com.example.flights.presentation.ui.theme.Main050
import com.example.flights.presentation.ui.theme.Main300
import com.example.flights.presentation.ui.theme.Neutral050

@Composable
fun FlightScreen(
    viewModel: FlightScreenViewModel,
    onBackButtonClicked: () -> Unit
) {

    val uiState = viewModel.flightScreenUIState.collectAsState().value
    val isLoading = uiState.isLoading
    val flightList = uiState.flightList
    val isDarkTheme = isSystemInDarkTheme()


    Scaffold(
        topBar = {
            FlightScreenAppBar(
                isDarkTheme = isDarkTheme,
                flightCode = uiState.flightCode,
                onBackButtonClicked = onBackButtonClicked
            )
        },
        containerColor = if (isDarkTheme) Main300 else Neutral050
    ) { padding ->

        if (isLoading){
            Loading()
            LaunchedEffect(Unit){ viewModel.updateFlightList()}
        } else {
            FlightDisplay(
                padding = padding,
                flightList = flightList,
                isDarkTheme = isDarkTheme
            )
        }
    }


}