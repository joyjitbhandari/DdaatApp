package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.requestDatamodel.ForgotPwdOtpRequest
import com.example.ddaatapp.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.responseDatamodel.BaseResponse
import com.example.ddaatapp.responseDatamodel.OtpVerifyResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OTPViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    //Otp data
    private val otp_data = MutableLiveData<OtpVerifyResponse?>()
    val otpData: MutableLiveData<OtpVerifyResponse?> = otp_data

    //Resend OTP
    private val resedn_otp_data = MutableLiveData<BaseResponse?>()
    val resendOtpData: MutableLiveData<BaseResponse?> = resedn_otp_data


    //Forgot Password Otp data
    private val forgot_pwd_otp_data = MutableLiveData<BaseResponse?>()
    val forgotPwdOtpData: MutableLiveData<BaseResponse?> = forgot_pwd_otp_data


    //Otp Verify
    fun otpVerify(otpVerifyRequest: OtpVerifyRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.otpVerify(otpVerifyRequest)
                }

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
    fun resendOtp(userId:String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.resendOtp(userId)
                }

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
    fun forgotPwdOtp(forgotPwdOtpRequest: ForgotPwdOtpRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.forgotPwdVerify(forgotPwdOtpRequest)
                }
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
