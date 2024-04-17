package com.example.get_location

import android.location.Location
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun DisplayLocation(
//    location: MutableState<Location?>
    location: Location?
){
    if (location != null){
        Text(text = "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
    } else {
        Text(text = "Location not available")
    }
}