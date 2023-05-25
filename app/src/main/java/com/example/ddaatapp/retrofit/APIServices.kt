package com.example.ddaatapp.retrofit
import com.example.ddaatapp.postDatamodel.PostOtpVerify
import com.example.ddaatapp.postDatamodel.PostUserSignUp
import com.example.ddaatapp.responseDatamodel.ResponseOtpVerify
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIServices {

     @POST("register")
     fun userSignup(
        @Body userSignUp: com.example.ddaatapp.postDatamodel.PostUserSignUp
    ): Call<com.example.ddaatapp.responseDatamodel.ResponseUserSignUp>


    @POST("verify-otp")
   fun otpVerify(
        @Body otpVerify: PostOtpVerify
    ): Call<ResponseOtpVerify>


}