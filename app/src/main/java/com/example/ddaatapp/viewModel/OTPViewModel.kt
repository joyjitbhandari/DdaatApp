package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.model.requestDatamodel.ForgotPwdOtpRequest
import com.example.ddaatapp.model.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.model.responseDatamodel.BaseResponse
import com.example.ddaatapp.model.responseDatamodel.OtpVerifyResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.launch

class OTPViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //Otp data
    private val otp_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.OtpVerifyResponse?>()
    val otpData: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.OtpVerifyResponse?> = otp_data

    //Resend OTP
    private val resedn_otp_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?>()
    val resendOtpData: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?> = resedn_otp_data


    //Forgot Password Otp data
    private val forgot_pwd_otp_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?>()
    val forgotPwdOtpData: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.BaseResponse?> = forgot_pwd_otp_data


    //Otp Verify
    fun otpVerify(otpVerifyRequest: com.example.ddaatapp.model.requestDatamodel.OtpVerifyRequest) {
        viewModelScope.launch {
            try {
                val response = apiService.otpVerify(otpVerifyRequest)

                if (response.isSuccessful) {
                    otp_data.value = response.body()
                    Log.d("get", "${response.body()} ")
                } else {
                    _toastMsg.postValue(Event("${response.code()}${response.message()}"?: "Something Went Wrong"))
                }
            } catch (e: Exception) {
                _toastMsg.postValue(Event("${e.printStackTrace()}"?: "Something Went Wrong"))
            }
        }
    }

    //Resend OTP
    fun resendOtp(fields: Map<String, String>) {
        viewModelScope.launch {
            try {
                val response = apiService.resendOtp(fields)
                if (response.isSuccessful) {
                    resedn_otp_data.value = response.body()
                    Log.d("get", "${response.body()} ")
                } else {
                    _toastMsg.postValue(Event("${response.code()}${response.message()}"?: "Something Went Wrong"))
                }
            } catch (e: Exception) {
                _toastMsg.postValue(Event("${e.printStackTrace()}"?: "Something Went Wrong"))
            }
        }
    }

    //Forgot Pwd
    fun forgotPwdVerify(forgotPwdOtpRequest: com.example.ddaatapp.model.requestDatamodel.ForgotPwdOtpRequest) {
        viewModelScope.launch {
            try {
                val response = apiService.forgotPwdVerify(forgotPwdOtpRequest)

                if (response.isSuccessful)
                    forgot_pwd_otp_data.value = response.body()
                else
                    _toastMsg.postValue(
                        Event(
                            "${response.code()}${response.message()}" ?: "Something Went Wrong"
                        )
                    )
            }catch (e: Exception){
                _toastMsg.postValue(Event("${e.printStackTrace()}"?: "Something Went Wrong"))
            }
        }
    }
}
