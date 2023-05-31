package com.example.ddaatapp.retrofit

import com.example.ddaatapp.requestDatamodel.LoginRequest
import com.example.ddaatapp.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.requestDatamodel.ResendOtpRequest
import com.example.ddaatapp.requestDatamodel.SignUpRequest
import com.example.ddaatapp.responseDatamodel.LoginResponse
import com.example.ddaatapp.responseDatamodel.OtpVerifyResponse
import com.example.ddaatapp.responseDatamodel.ResendOtpResponse
import com.example.ddaatapp.responseDatamodel.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIServices {

    @POST("register")
    fun userSignup(
        @Body signUpRequest: SignUpRequest
    ): Call<SignUpResponse>


    @POST("verify-otp")
    fun otpVerify(
        @Body otpVerifyRequest: OtpVerifyRequest
    ): Call<OtpVerifyResponse>

    @POST("resend-otp")
    fun resendOtp(
        @Body resendOtpRequest: ResendOtpRequest
    ): Call<ResendOtpResponse>

    @POST("login")
    fun login(@Body logInRequest: LoginRequest): Call<LoginResponse>


}