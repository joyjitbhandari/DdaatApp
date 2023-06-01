package com.example.ddaatapp.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.repository.Repository
import com.example.ddaatapp.requestDatamodel.*
import com.example.ddaatapp.responseDatamodel.*
import com.example.ddaatapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(RetrofitInstance.apiServices)
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

    //Forgot Password data
    private val forgot_pwd_data = MutableLiveData<ForgotPwdResponse?>()
    val forgotPwdData: MutableLiveData<ForgotPwdResponse?> = forgot_pwd_data

    //Forgot Password Otp data
    private val forgot_pwd_otp_data = MutableLiveData<ForgotPwdOtpResponse?>()
    val forgotPwdOtpData: MutableLiveData<ForgotPwdOtpResponse?> = forgot_pwd_otp_data

    //Change Password
    private val change_pwd_data = MutableLiveData<ChangePwdResponse?>()
    val changePwdData: MutableLiveData<ChangePwdResponse?> = change_pwd_data

    //SignUp
    fun signUp(signUpRequest: SignUpRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.signUp(signUpRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    signUp_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

    //Otp Verify
    fun otpVerify(otpVerifyRequest: OtpVerifyRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.otpVerify(otpVerifyRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    otp_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

    //Resend OTP
    fun resendOtp(resendOtpRequest: ResendOtpRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.resendOtp(resendOtpRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    resedn_otp_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

    //Log In
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.login(loginRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    login_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

    //Forgot Pwd
    fun forgotPwd(forgotPwdRequest: ForgotPwdRequest){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.forgotPwd(forgotPwdRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    forgot_pwd_data.value = apiResponse
                    Log.d("get", "${response.body()} ")

                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

    //Forgot Pwd
    fun forgotPwdOtp(forgotPwdOtpRequest: ForgotPwdOtpRequest){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.forgotPwdOtp(forgotPwdOtpRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    forgot_pwd_otp_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }

    }

    //Change Password
    fun changePwd(changePwdRequest: ChangePwdRequest){
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.changePwd(changePwdRequest)
                }

                // Handle the response as needed
                if (response.isSuccessful) {
                    // User created successfully
                    val apiResponse = response.body()
                    change_pwd_data.value = apiResponse
                    Log.d("get", "${response.body()} ")
                    // Update UI or perform additional actions
                } else {
                    // Handle the error response
                    val errorBody = response.errorBody()
                    Toast.makeText((this as AppCompatActivity), "${errorBody.toString()}", Toast.LENGTH_SHORT).show()
                    // Extract error information and show appropriate feedback
                }
            } catch (e: Exception) {
                // Handle any exception that occurred during the network operation
                // Update UI with an error state or show an error message
                Log.d("error", "${e.message} ")
            }
        }
    }

}
