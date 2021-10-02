package com.example.weatherapp.network

import com.example.weatherapp.weatherdata.Current
import com.example.weatherapp.weatherdata.Location
import com.google.gson.annotations.SerializedName
   
data class WeatherData (
   @SerializedName("location") var location : Location,
   @SerializedName("current") var current : Current,
)