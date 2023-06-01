package com.example.ddaatapp.retrofit

import com.example.ddaatapp.requestDatamodel.*
import com.example.ddaatapp.responseDatamodel.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIServices {

    @POST("register")
    suspend fun userSignup(
        @Body signUpRequest: SignUpRequest
    ): Response<SignUpResponse>


    @POST("verify-otp")
    suspend fun otpVerify(
        @Body otpVerifyRequest: OtpVerifyRequest
    ): Response<OtpVerifyResponse>

    @POST("resend-otp")
    suspend fun resendOtp(
        @Body resendOtpRequest: ResendOtpRequest
    ): Response<ResendOtpResponse>

    @POST("login")
    suspend fun login(@Body logInRequest: LoginRequest): Response<LoginResponse>

    @POST("forgot-password")
    suspend fun forgotPwd(@Body forgotPwdRequest: ForgotPwdRequest): Response<ForgotPwdResponse>

    @POST("forgot-password-verify")
    suspend fun forgotPwd(@Body forgotPwdOtpRequest: ForgotPwdOtpRequest): Response<ForgotPwdOtpResponse>

    @POST("changePassword")
    suspend fun changePwd(@Body changePwdRequest: ChangePwdRequest): Response<ChangePwdResponse>

    @POST("update-profile")
    suspend fun updateProfile(@Body changePwdRequest: ChangePwdRequest): Response<ChangePwdResponse>

}