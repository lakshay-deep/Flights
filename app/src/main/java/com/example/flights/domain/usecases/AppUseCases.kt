package com.example.flights.domain.usecases

import com.example.flights.domain.usecases.airports.GetAirportMatching
import com.example.flights.domain.usecases.airports.GetFlightFromAirport

data class AppUseCases(
    val getAirportMatching: GetAirportMatching,
    val getFlightFromAirport: GetFlightFromAirport
)