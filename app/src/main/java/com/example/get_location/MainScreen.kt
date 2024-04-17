package com.example.get_location

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(){

    val viewModel : LocationViewModel = viewModel(factory = LocationViewModel.Factory)

    val userLocation = viewModel.location.collectAsState()
    Text(text = "${userLocation.value?.latitude}")
}