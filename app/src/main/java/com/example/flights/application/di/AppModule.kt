package com.example.flights.application.di

import android.app.Application
import androidx.room.Room
import com.example.flights.data.db.AppDatabase
import com.example.flights.data.repository.AirportDataRepositoryImpl
import com.example.flights.data.repository.BookmarkedFlightDataRepositoryImpl
import com.example.flights.domain.repository.AirportDataRepository
import com.example.flights.domain.usecases.AppUseCases
import com.example.flights.domain.usecases.airports.GetAirportMatching
import com.example.flights.domain.usecases.airports.GetFlightFromAirport
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAppDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(
                app.applicationContext,
                AppDatabase::class.java,
                AppDatabase.databaseName
            )
            .createFromAsset("database/flight_search.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAirportDataRepository(db: AppDatabase): AirportDataRepository {
        return AirportDataRepositoryImpl(db.airportDao())
    }

    @Provides
    @Singleton
    fun provideBookmarkedFlightsDataRepository(db: AppDatabase): BookmarkedFlightDataRepositoryImpl {
        return BookmarkedFlightDataRepositoryImpl(db.bookmarkedFlightsDao())
    }

    @Provides
    @Singleton
    fun providesAppUseCases(airportDataRepository: AirportDataRepository): AppUseCases {
        return AppUseCases(
            GetAirportMatching(airportDataRepository),
            GetFlightFromAirport(airportDataRepository)
        )
    }
}