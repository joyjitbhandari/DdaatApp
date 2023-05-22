package com.example.ddaatapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://dev-ddaat-admin.flynautstaging.com/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiServices: APIServices by lazy {
        retrofit.create(APIServices::class.java)
    }
}