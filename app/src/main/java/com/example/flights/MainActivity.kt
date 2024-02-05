package com.example.flights

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.flights.application.navigation.NavGraph
import com.example.flights.presentation.ui.theme.FlightsTheme
import com.example.flights.presentation.ui.theme.Main300
import com.example.flights.presentation.ui.theme.Neutral050
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FlightsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = if (isSystemInDarkTheme()) Main300 else Neutral050) {
                    val navHostController = rememberNavController()
                    NavGraph(navHostController)
                }
            }
        }
    }
}