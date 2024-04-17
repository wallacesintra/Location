package com.example.get_location

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.get_location.location.LocationDataSource
import com.example.get_location.location.models.LocationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationDataSource: LocationDataSource
): ViewModel(){
//    val location: Flow<LocationModel> =  locationDataSource.fetchCurrentLocation()
    private val _location = MutableStateFlow<LocationModel?>(null)
    val location: StateFlow<LocationModel?> get() = _location
    val latitude = location.value?.latitude

    init {
        fetchLocation()
    }

    private fun fetchLocation() {
        viewModelScope.launch {
//           locationDataSource.fetchCurrentLocation().collect {location ->
//               _location.value = location
//           }
            _location.value = locationDataSource.fetchCurrentLocation().first()

        }
    }

//    companion object{
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as LocationApplication)
//                val locationDataSource = application.container.locationDataSource
//                LocationViewModel(locationDataSource)
//            }
//        }
//    }


    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LocationApplication)
                val locationDataSource = application.container.locationDataSource
                LocationViewModel(locationDataSource)
            }
        }
    }

}