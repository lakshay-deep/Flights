package com.example.flights.data.db.bookmarked

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flights.data.db.bookmarked.entities.BookmarkedFlightEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkedFlightsDao {
    @Query(
        """
			SELECT * FROM bookmarked
		"""
    )
    fun getBookmarkedAirports(): Flow<List<BookmarkedFlightEntity>>

    @Query(
        """
			SELECT EXISTS (SELECT 1 FROM bookmarked WHERE departure_code = :code LIMIT 1)
		"""
    )
    suspend fun isAirportBookmarked(code: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAirportToBookmarks(airport: BookmarkedFlightEntity)

    @Delete
    suspend fun removeAirportFromBookmarks(airport: BookmarkedFlightEntity)
}