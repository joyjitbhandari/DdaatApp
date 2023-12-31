package com.example.ddaatapp.network

import com.example.ddaatapp.model.requestDatamodel.*
import com.example.ddaatapp.model.responseDatamodel.*
import retrofit2.Response
import retrofit2.http.*

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
        @FieldMap fields : Map<String, String>
    ): Response<BaseResponse>

    @POST("login")
    suspend fun login(@Body logInRequest: LoginRequest): Response<LoginResponse>

    @FormUrlEncoded
    @POST("forgot-password")
    suspend fun forgotPwd(@FieldMap fields : Map<String, String>): Response<BaseResponse>

    @POST("forgot-password-verify")
    suspend fun forgotPwdVerify(@Body forgotPwdOtpRequest: ForgotPwdOtpRequest): Response<BaseResponse>

    @POST("changePassword")
    suspend fun changePwd(@Body changePwdRequest:ChangePwdRequest): Response<BaseResponse>

    @POST("get-profile")
    suspend fun  getProfile(): Response<UpdateProfileResponse>

    @POST("update-profile")
    suspend fun  updateProfile(@Body updateProfileRequest: UpdateProfileRequest): Response<UpdateProfileResponse>

    @POST("subscription-list")
    suspend fun getSubscriptionList(): Response<SubscriptionListResponse>

    @POST("blog-list")
    suspend fun getBlogList(): Response<BlogListResponse>

    @POST("blog-detail")
    suspend fun getBlogDetail(@QueryMap fields : Map<String, Int>): Response<BlogDetails>

    @POST("category-list")
    suspend fun getCategory(): Response<CategoryList>

    @POST("faq-list")
    suspend fun getFaqs(): Response<FaqListResponse>

}