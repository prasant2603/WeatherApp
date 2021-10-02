package com.example.weatherapp.repository

import com.example.weatherapp.network.WeatherData
import com.example.weatherapp.network.retrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<WeatherData>
    {
        return  retrofitInstance.api.getPost()
    }

}