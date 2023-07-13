package com.example.ddaatapp.network

import android.util.Log
import com.flynaut.healthtag.util.PrefsManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Response


class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = PrefsManager.get().getString(PrefsManager.PREF_API_TOKEN,null)

        val request = if (token != null) {
            Log.d("token", "intercept: $token ")
            originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(request)
    }


}