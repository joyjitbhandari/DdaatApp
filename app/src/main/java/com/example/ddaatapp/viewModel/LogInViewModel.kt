package com.example.ddaatapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.model.requestDatamodel.LoginRequest
import com.example.ddaatapp.model.responseDatamodel.LoginResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LogInViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //Otp data
    private val _apiResponse = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.LoginResponse>()
    val apiResponse: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.LoginResponse> = _apiResponse


    fun login(loginRequest: com.example.ddaatapp.model.requestDatamodel.LoginRequest) {
        viewModelScope.launch {
            try {
                val response = apiService.login(loginRequest)
                if (response.isSuccessful)
                    _apiResponse.value = response.body()
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("Invalid UserName" ))
            }
        }
    }

}
