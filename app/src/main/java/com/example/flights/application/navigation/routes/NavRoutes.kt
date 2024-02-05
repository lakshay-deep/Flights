package com.example.flights.application.navigation.routes



enum class NavRoutes {
    Home,
    Flights
}
object Routes {
    val home: String = NavRoutes.Home.name
    val flights: String = NavRoutes.Flights.name
}