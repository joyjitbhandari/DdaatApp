package com.example.ddaatapp.retrofit
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import com.example.ddaatapp.postDatamodel.PostUserSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIServices {

    @POST("register")
    fun userSignup(
        @Body userSignUp: PostUserSignUp
    ): Call<ResponseUserSignUp>
}