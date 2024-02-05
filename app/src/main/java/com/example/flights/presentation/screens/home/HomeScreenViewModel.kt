package com.example.flights.presentation.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flights.data.db.airport.entities.AirportEntity
import com.example.flights.domain.usecases.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class HomeScreenUIState(
    val isLoading : Boolean = false,
    val searchQuery : String = "",
    val searchResult : List<AirportEntity> = emptyList()
)

private const val TAG = "VIEWMODEL"
@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val appUseCases: AppUseCases): ViewModel() {

    private val _homeScreenUIState = MutableStateFlow(HomeScreenUIState())
    val uiState: StateFlow<HomeScreenUIState> = _homeScreenUIState.asStateFlow()

    fun updateSearchQuery(newQuery: String){
        viewModelScope.launch {
            _homeScreenUIState.update { state ->
                state.copy(
                    isLoading = true,
                    searchQuery = newQuery
                )
            }
            delay(5000)

            appUseCases.getAirportMatching(newQuery)
                .catch {err ->
                    Log.d(TAG, "Getting Error Matching Airports : $err")
                }.collect{airports ->
                    _homeScreenUIState.update {state ->
                        state.copy(
                            isLoading = false,
                            searchResult = airports
                        )
                    }

                }
        }


    }
}