package com.example.flights.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.flights.R
import com.example.flights.data.db.airport.entities.AirportEntity

@Composable
fun FlightDisplay(
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    flightList: List<AirportEntity>,
    isDarkTheme: Boolean
) {
    LazyColumn(
        modifier = modifier.padding(padding),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_24))
    ) {
        items(items = flightList, key = { it.id }) { airport ->
            FlightDestinationItem(
                number = flightList.indexOf(airport) + 1,
                name = airport.name,
                isDarkTheme = isDarkTheme,
                isBookmarked = false
            )
        }
    }
}