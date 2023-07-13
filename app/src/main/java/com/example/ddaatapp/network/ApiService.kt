package com.example.ddaatapp.network

import com.example.ddaatapp.requestDatamodel.*
import com.example.ddaatapp.responseDatamodel.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("register")
    suspend fun signup(
        @Body signUpRequest: SignUpRequest
    ): Response<BaseResponse>


    @POST("verify-otp")
    suspend fun otpVerify(
        @Body otpVerifyRequest: OtpVerifyRequest
    ): Response<OtpVerifyResponse>

    @FormUrlEncoded
    @POST("resend-otp")
    suspend fun resendOtp(
        @Body user_id: String
    ): Response<BaseResponse>

    @POST("login")
    suspend fun login(@Body logInRequest: LoginRequest): Response<LoginResponse>

    @POST("forgot-password")
    suspend fun forgotPwd(@Body email: String): Response<BaseResponse>

    @POST("forgot-password-verify")
    suspend fun forgotPwdVerify(@Body forgotPwdOtpRequest: ForgotPwdOtpRequest): Response<BaseResponse>

    @POST("changePassword")
    suspend fun changePwd(@Body changePwdRequest: ChangePwdRequest): Response<BaseResponse>

    @POST("update-profile")
    suspend fun  updateProfile(@Body updateProfileRequest: UpdateProfileRequest): Response<UpdateProfileResponse>

}