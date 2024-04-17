package com.example.get_location

import android.app.Activity
import android.content.Context
import com.example.get_location.location.LocationDataSource
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices

interface AppContainer{
    val locationDataSource: LocationDataSource
}

class DefaultContainer(
//    private val activity: Activity,
    private val applicationContext:  Context,
//    private val fusedLocationClient: FusedLocationProviderClient,
): AppContainer{

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)

    override val locationDataSource: LocationDataSource by lazy {
        LocationDataSource(
//            activity = activity,
            context = applicationContext,
            fusedLocationClient= fusedLocationClient,
            currentLocationRequest = LocationRequest.create()
        )
    }
}