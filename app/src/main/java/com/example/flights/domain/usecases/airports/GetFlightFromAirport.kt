package com.example.flights.domain.usecases.airports

import com.example.flights.data.FlightsDataMap
import com.example.flights.data.db.airport.entities.AirportEntity
import com.example.flights.domain.repository.AirportDataRepository
import kotlinx.coroutines.runBlocking

class GetFlightFromAirport(private val airportDataRepository: AirportDataRepository) {

    operator fun invoke(code: String): List<AirportEntity> {
        val flights = mutableListOf<AirportEntity>()


        runBlocking {
            val airport = FlightsDataMap[code]

            if (airport != null){
                for (flight in airport){
                    flights.add(airportDataRepository.getAirportByCode(flight)!!)
                }
            }
        }

        return flights.toList()
    }
}