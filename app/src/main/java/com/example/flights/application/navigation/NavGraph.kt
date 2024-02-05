package com.example.flights.application.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flights.application.navigation.routes.Routes
import com.example.flights.presentation.screens.flights.FlightScreen
import com.example.flights.presentation.screens.flights.FlightScreenViewModel
import com.example.flights.presentation.screens.home.HomeScreen
import com.example.flights.presentation.screens.home.HomeScreenViewModel


@ExperimentalMaterial3Api
@Composable
fun NavGraph(navHostController: NavHostController) {
    
    
    NavHost(navController = navHostController, startDestination = Routes.home) {
        composable(route = Routes.home){
            val viewModel = hiltViewModel<HomeScreenViewModel>()

            HomeScreen(
                viewModel= viewModel,
                onAirportItemClicked = { code ->
                    navHostController.navigate(Routes.flights.plus("/$code"))
                }
            )
        }


        composable(route = Routes.flights.plus("/{code}")){backStackEntry ->
            val flightCode = backStackEntry.arguments?.getString("code")!!
            val viewModel = hiltViewModel<FlightScreenViewModel>()

            viewModel.updateFlightCode(flightCode)

            FlightScreen(
                viewModel = viewModel,
                onBackButtonClicked = {navHostController.popBackStack()}
            )
        }
    }
}