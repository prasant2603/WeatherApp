package com.example.weatherapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitInstance {
    private  val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL).
            addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}