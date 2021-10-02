package com.example.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherData
import com.example.weatherapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class mainViewModel(private val repository: Repository) : ViewModel()
{
    val myresponse: MutableLiveData<Response<WeatherData>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myresponse.value=response
        }
    }
}
class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel(repository) as T
    }
}