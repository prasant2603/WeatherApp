package com.example.weatherapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi
{
    @GET("current.json")
    suspend fun getPost(@Query("key")key :String="b0687703b17b462a9a8125741210110",
                         @Query("q") q :String ="Ghaziabad")
        :Response<WeatherData>
}