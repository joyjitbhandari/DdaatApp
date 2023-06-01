package com.example.ddaatapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ddaatapp.requestDatamodel.*
import com.example.ddaatapp.responseDatamodel.*
import com.example.ddaatapp.retrofit.APIServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val apiService: APIServices) {

    //SignUp
     suspend fun signUp(signUpRequest: SignUpRequest) : Response<SignUpResponse> {
        return apiService.userSignup(signUpRequest)
    }


    //Otp Verify
    suspend fun otpVerify(otpVerifyRequest: OtpVerifyRequest) : Response<OtpVerifyResponse> {
        return apiService.otpVerify(otpVerifyRequest)
    }

    //Resend OTP
    suspend fun resendOtp(resendOtpRequest: ResendOtpRequest): Response<ResendOtpResponse> {
        return apiService.resendOtp(resendOtpRequest)
    }


    //User Login
    suspend fun login(loginRequest: LoginRequest):Response<LoginResponse> {
        return apiService.login(loginRequest)
    }

    //Forgot Pwd
    suspend fun forgotPwd(forgotPwdRequest: ForgotPwdRequest):Response<ForgotPwdResponse>{
       return apiService.forgotPwd(forgotPwdRequest)
    }

    //Forgot Pwd Otp
   suspend fun forgotPwdOtp(forgotPwdOtpRequest: ForgotPwdOtpRequest): Response<ForgotPwdOtpResponse>{
       return apiService.forgotPwd(forgotPwdOtpRequest)
    }

    //Change Pwd
    suspend fun changePwd(changePwdRequest: ChangePwdRequest) : Response<ChangePwdResponse>{
        return apiService.changePwd(changePwdRequest)
    }
}