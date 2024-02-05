package com.example.flights.domain.usecases.airports

import com.example.flights.data.db.airport.entities.AirportEntity
import com.example.flights.domain.repository.AirportDataRepository
import kotlinx.coroutines.flow.Flow

class GetAirportMatching(private val airportDataRepository: AirportDataRepository) {

    operator fun invoke(identifier: String): Flow<List<AirportEntity>> {
        return airportDataRepository.getAirportByQuery(identifier)
    }
}