package com.example.ddaatapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ddaatapp.requestDatamodel.LoginRequest
import com.example.ddaatapp.requestDatamodel.OtpVerifyRequest
import com.example.ddaatapp.requestDatamodel.ResendOtpRequest
import com.example.ddaatapp.requestDatamodel.SignUpRequest
import com.example.ddaatapp.responseDatamodel.LoginResponse
import com.example.ddaatapp.responseDatamodel.OtpVerifyResponse
import com.example.ddaatapp.responseDatamodel.ResendOtpResponse
import com.example.ddaatapp.responseDatamodel.SignUpResponse
import com.example.ddaatapp.retrofit.APIServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val apiService: APIServices) {
    //sign up data
    private val signUp_data = MutableLiveData<SignUpResponse?>()
    val signUpData: MutableLiveData<SignUpResponse?> = signUp_data

    //Otp data
    private val otp_data = MutableLiveData<OtpVerifyResponse?>()
    val otpData: MutableLiveData<OtpVerifyResponse?> = otp_data

    //Resend OTP
    private val resedn_otp_data = MutableLiveData<ResendOtpResponse?>()
    val resendOtpData: MutableLiveData<ResendOtpResponse?> = resedn_otp_data

    //LogIn data
    private val login_data = MutableLiveData<LoginResponse?>()
    val loginData: MutableLiveData<LoginResponse?> = login_data


    //SignUp
     fun signUp(signUpRequest: SignUpRequest) {
        apiService.userSignup(signUpRequest).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    signUp_data.value = responseData
                } else {
                    // Handle unsuccessful response

                }
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }


    //Otp Verify
    fun otpVerify(otpVerifyRequest: OtpVerifyRequest) {
        apiService.otpVerify(otpVerifyRequest).enqueue(object : Callback<OtpVerifyResponse> {
            override fun onResponse(
                call: Call<OtpVerifyResponse>,
                response: Response<OtpVerifyResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    otp_data.value = responseData
                } else {
                    // Handle unsuccessful response

                }
            }

            override fun onFailure(call: Call<OtpVerifyResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

    //Resend OTP
    fun resendOtp(resendOtpRequest: ResendOtpRequest) {
        apiService.resendOtp(resendOtpRequest).enqueue(object : Callback<ResendOtpResponse> {
            override fun onResponse(
                call: Call<ResendOtpResponse>,
                response: Response<ResendOtpResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    resedn_otp_data.value = responseData
                } else {
                    // Handle unsuccessful response

                }
            }

            override fun onFailure(call: Call<ResendOtpResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }


    //User Login
    fun login(loginRequest: LoginRequest) {
        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>,
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    login_data.value = responseData
                    Log.d("get", "${response.body()} ")

                } else {
                    // Handle unsuccessful response
                    Log.d("failure", " api request error")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

}