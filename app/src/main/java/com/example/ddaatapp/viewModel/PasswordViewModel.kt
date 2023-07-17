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

class PasswordViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //Forgot Password data
    private val forgot_pwd_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?>()
    val forgotPwdData: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?> = forgot_pwd_data

    //Change Password
    private val change_pwd_data: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?> = MutableLiveData()
    val baseResponse: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?> get() = change_pwd_data

    //Forgot Pwd
    fun forgotPwd(fields: Map<String,String>) {
        viewModelScope.launch {
//            try{
                val response = apiService.forgotPwd(fields)

                if (response.isSuccessful) {
                    forgot_pwd_data.value = response.body()
                    Log.d("get", "${response.body()} ")
                } else
                    _toastMsg.postValue(Event(response.message().toString() ?: "Something Went Wrong"))
//            } catch (e: Exception) {
//                Log.d("error", "${e.message} ")
//            }
        }
    }

    //Change Password
    fun changePwd(changePwdRequest: com.example.ddaatapp.model.requestDatamodel.ChangePwdRequest) {
        viewModelScope.launch {
            val response = apiService.changePwd(changePwdRequest)
            if (response.isSuccessful)
                change_pwd_data.value = response.body()
            else
                _toastMsg.postValue(Event(response.message().toString() ?: "Something Went Wrong"))
        }
    }
}
