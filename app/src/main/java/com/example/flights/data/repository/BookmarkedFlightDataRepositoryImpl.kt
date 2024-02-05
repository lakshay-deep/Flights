package com.example.flights.data.repository

import com.example.flights.data.db.bookmarked.BookmarkedFlightsDao
import com.example.flights.data.db.bookmarked.entities.BookmarkedFlightEntity
import com.example.flights.domain.repository.BookmarkedFlightDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkedFlightDataRepositoryImpl @Inject constructor(
    private val bookmarkedFlightsDao: BookmarkedFlightsDao
): BookmarkedFlightDataRepository {
    override fun getBookmarkedAirports(): Flow<List<BookmarkedFlightEntity>> {
        return bookmarkedFlightsDao.getBookmarkedAirports()
    }

    override suspend fun isAirportBookmarked(code: String): Boolean {
        return bookmarkedFlightsDao.isAirportBookmarked(code)
    }

    override suspend fun addAirportToBookmarked(airport: BookmarkedFlightEntity) {
        return bookmarkedFlightsDao.addAirportToBookmarks(airport)
    }

    override suspend fun removeAirportFromBookmarks(airport: BookmarkedFlightEntity) {
        return bookmarkedFlightsDao.removeAirportFromBookmarks(airport)
    }
}