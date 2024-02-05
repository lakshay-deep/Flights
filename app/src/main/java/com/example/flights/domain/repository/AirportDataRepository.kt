package com.example.flights.domain.repository

import com.example.flights.data.db.airport.entities.AirportEntity
import kotlinx.coroutines.flow.Flow


interface AirportDataRepository {
    fun getAirportByQuery(identifier: String): Flow<List<AirportEntity>>
    suspend fun getAirportByCode(code: String): AirportEntity?
}