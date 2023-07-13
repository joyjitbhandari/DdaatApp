package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.requestDatamodel.*
import com.example.ddaatapp.responseDatamodel.*
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUPViewModel(private val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //sign up data
    private val signUp_data = MutableLiveData<BaseResponse>()
    val signUpData: MutableLiveData<BaseResponse> = signUp_data


    //SignUp
    fun signUp(signUpRequest: SignUpRequest) {
        viewModelScope.launch {
//            try {
            val response = withContext(Dispatchers.IO) {
                apiService.signup(signUpRequest)
            }
            if (response.isSuccessful) {
                if(response.body()?.success == true){
                    signUp_data.value = response.body()
                    Log.d("get", "${response.body()} ")
                }else{

                }

            } else
                _toastMsg.postValue(Event(response.message().toString() ?: "Something Went Wrong"))

//            } catch (e: Exception) {
//                Log.d("error", "${e.message} ")
//            }
        }
    }

}
