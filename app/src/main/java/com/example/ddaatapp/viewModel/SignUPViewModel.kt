package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUPViewModel(private val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //sign up data
    private val signUp_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse>()
    val signUpData: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse> = signUp_data


    //SignUp
    fun signUp(signUpRequest: com.example.ddaatapp.model.requestDatamodel.SignUpRequest) {
        viewModelScope.launch {
//            try {
            val response = apiService.signup(signUpRequest)

            if (response.isSuccessful) {
                    signUp_data.value = response.body()
                    Log.d("get", "${response.body()} ")
            } else
                _toastMsg.postValue(Event(response.message().toString() ?: "Something Went Wrong"))

//            } catch (e: Exception) {
//                Log.d("error", "${e.message} ")
//            }
        }
    }

}
