package com.example.weatherapp.weatherdata

import com.google.gson.annotations.SerializedName

   
data class Location (

   @SerializedName("name") var name : String,
   @SerializedName("region") var region : String,
   @SerializedName("country") var country : String,
   @SerializedName("lat") var lat : Double,
   @SerializedName("lon") var lon : Double,
   @SerializedName("tz_id") var tzId : String,
   @SerializedName("localtime_epoch") var localtimeEpoch : Int,
   @SerializedName("localtime") var localtime : String

)