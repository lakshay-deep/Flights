package com.example.flights.domain.repository

import com.example.flights.data.db.bookmarked.entities.BookmarkedFlightEntity
import kotlinx.coroutines.flow.Flow

interface BookmarkedFlightDataRepository {
    fun getBookmarkedAirports(): Flow<List<BookmarkedFlightEntity>>
    suspend fun isAirportBookmarked(code: String): Boolean
    suspend fun addAirportToBookmarked(airport: BookmarkedFlightEntity)
    suspend fun removeAirportFromBookmarks(airport: BookmarkedFlightEntity)
}