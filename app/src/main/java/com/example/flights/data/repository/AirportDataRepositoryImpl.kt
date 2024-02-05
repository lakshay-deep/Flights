package com.example.flights.data.repository

import com.example.flights.data.db.airport.AirportDao
import com.example.flights.data.db.airport.entities.AirportEntity
import com.example.flights.domain.repository.AirportDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AirportDataRepositoryImpl @Inject constructor(private val airportDao: AirportDao): AirportDataRepository {
    override fun getAirportByQuery(identifier: String): Flow<List<AirportEntity>> {
        return airportDao.getAirportByQuery(identifier)
    }

    override suspend fun getAirportByCode(code: String): AirportEntity? {
        return airportDao.getAirportByCode(code)
    }
}