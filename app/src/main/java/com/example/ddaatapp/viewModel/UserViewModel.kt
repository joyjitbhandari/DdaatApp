package com.example.ddaatapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.repository.Repository
import com.example.ddaatapp.requestDatamodel.LoginRequest
import com.example.ddaatapp.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.requestDatamodel.ResendOtpRequest
import com.example.ddaatapp.requestDatamodel.SignUpRequest
import com.example.ddaatapp.responseDatamodel.LoginResponse
import com.example.ddaatapp.responseDatamodel.OtpVerifyResponse
import com.example.ddaatapp.responseDatamodel.ResendOtpResponse
import com.example.ddaatapp.responseDatamodel.SignUpResponse
import com.example.ddaatapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(RetrofitInstance.apiServices)
    //signup
    val signUpData: MutableLiveData<SignUpResponse?> = repository.signUpData

    //otp
    val otpData: MutableLiveData<OtpVerifyResponse?> = repository.otpData

    //otp
    val resendOtpData: MutableLiveData<ResendOtpResponse?> = repository.resendOtpData

    //login
    val loginData: MutableLiveData<LoginResponse?> = repository.loginData


    //SignUp
    fun signUp(signUpRequest: SignUpRequest) {
        repository.signUp(signUpRequest)
    }

    //Otp Verify
    fun otpVerify(otpVerifyRequest: OtpVerifyRequest) {
        repository.otpVerify(otpVerifyRequest)
    }

    //Resend OTP
    fun resendOtp(resendOtpRequest: ResendOtpRequest) {
        repository.resendOtp(resendOtpRequest)
    }

    //Log In
    fun login(loginRequest: LoginRequest) {
        repository.login(loginRequest)
    }
}
