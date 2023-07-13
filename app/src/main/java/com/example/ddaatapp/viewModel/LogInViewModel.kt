package com.example.ddaatapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.requestDatamodel.LoginRequest
import com.example.ddaatapp.responseDatamodel.LoginResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LogInViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //Otp data
    private val _apiResponse = MutableLiveData<LoginResponse>()
    val apiResponse: MutableLiveData<LoginResponse> = _apiResponse


    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.login(loginRequest)
                }
                if (response.isSuccessful)
                    _apiResponse.value = response.body()
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("${e.printStackTrace()}" ?: "Something Went Wrong"))
            }
        }
    }

}
