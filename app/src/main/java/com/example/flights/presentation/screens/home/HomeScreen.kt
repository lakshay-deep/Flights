package com.example.flights.presentation.screens.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.flights.presentation.ui.components.FlightSearch
import com.example.flights.presentation.ui.components.SearchBar
import com.example.flights.presentation.ui.theme.Main300
import com.example.flights.presentation.ui.theme.Neutral050
@ExperimentalMaterial3Api
@Composable
fun  HomeScreen(
    viewModel:HomeScreenViewModel,
    onAirportItemClicked: (String) -> Unit
) {
    val uiState by  viewModel.uiState.collectAsState()
    val isLoading = uiState.isLoading
    val searchResult = uiState.searchResult
    val isDarkTheme = isSystemInDarkTheme()


    Scaffold(
        topBar = {
            SearchBar(
                isDarkTheme = isDarkTheme,
                searchQuery = uiState.searchQuery,
                onSearchQueryChange = {viewModel.updateSearchQuery(it)}
            )
        },
        containerColor = if (isDarkTheme) Main300 else Neutral050
    ) { padding ->
        if(uiState.searchQuery.isNotEmpty()){
            FlightSearch(
                padding = padding,
                isDarkTheme = isDarkTheme,
                isLoading = isLoading,
                searchResult = searchResult,
                searchQuery = uiState.searchQuery,
                onAirportItemClicked = {
                    onAirportItemClicked(it)
                }
            )
        }
    }
}