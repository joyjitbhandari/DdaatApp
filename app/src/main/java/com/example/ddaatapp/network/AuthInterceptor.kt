package com.example.ddaatapp.network

import com.flynaut.healthtag.util.PrefsManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = PrefsManager.get().getString(PrefsManager.PREF_API_TOKEN,null)

        val request = if (token != null) {
            originalRequest.newBuilder()
                .header("Authorization", "$token")
                .build()
        } else {
            originalRequest
        }

        return chain.proceed(request)
    }
}