package com.example.weatherapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.viewModel.MainViewModelFactory
import com.example.weatherapp.viewModel.mainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Define all layout
        val city: TextView =findViewById(R.id.textcity)
        val texttime: TextView =findViewById(R.id.texttime)
        val condtion: ImageView =findViewById(R.id.condition)
        val temp: TextView =findViewById(R.id.temperature)
        val wetmain: TextView =findViewById(R.id.weather_main)
        val humidity: TextView =findViewById(R.id.humidity_text)
        val pressure: TextView =findViewById(R.id.pressure_text)
        val windspeed: TextView =findViewById(R.id.wind_speed_text)

        //Current City
        city.text="Ghaziabad"

        //Fetching current time
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, HH:mm")
        val formatted = current.format(formatter)
        texttime.text=formatted.toString()

        //ViewModel
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel: mainViewModel = ViewModelProvider(this, viewModelFactory)
            .get(mainViewModel::class.java)
        viewModel.getPost()

        //Final Data Entry
        viewModel.myresponse.observe(this, Observer {
            if(it.isSuccessful)
            {
                temp.text=(it.body()?.current!!.tempC.toString()+"\u2103")
                wetmain.text= it.body()?.current!!.condition.text.toString()
                humidity.text=(it.body()?.current!!.humidity.toString()+"%")
                pressure.text=(it.body()?.current!!.pressureMb.toString()+"hPa")
                windspeed.text=it.body()?.current!!.windKph.toString()
            }
            else
            {
                Toast.makeText(this,"Failed to Fetch Weather Data",Toast.LENGTH_LONG).show()
            }
        })

    }
}