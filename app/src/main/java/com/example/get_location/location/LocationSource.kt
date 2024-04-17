package com.example.get_location.location

import com.example.get_location.location.models.LocationModel
import kotlinx.coroutines.flow.Flow

interface LocationSource {
    suspend fun fetchCurrentLocation(): Flow<LocationModel>
}