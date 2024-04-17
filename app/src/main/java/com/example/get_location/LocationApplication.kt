package com.example.get_location

import android.app.Activity
import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient

class LocationApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer(this)
    }
}