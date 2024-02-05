package com.example.flights.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flights.data.db.airport.AirportDao
import com.example.flights.data.db.airport.entities.AirportEntity
import com.example.flights.data.db.bookmarked.BookmarkedFlightsDao
import com.example.flights.data.db.bookmarked.entities.BookmarkedFlightEntity


@Database(
    entities = [AirportEntity::class, BookmarkedFlightEntity::class],
    exportSchema = false,
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
    abstract fun bookmarkedFlightsDao(): BookmarkedFlightsDao

    companion object {
        const val databaseName = "app_database"
    }
}