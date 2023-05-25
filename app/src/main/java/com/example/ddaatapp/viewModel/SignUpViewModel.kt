package com.example.ddaatapp.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.postDatamodel.PostUserSignUp
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import com.example.ddaatapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel(private val signUpViewModel: SignUpViewModel):ViewModel() {
    
    init {
        viewModelScope.launch(Dispatchers.IO) {
            fun postSignUp(postUserSignUp: com.example.ddaatapp.postDatamodel.PostUserSignUp) {
                val call = RetrofitInstance.apiServices.userSignup(postUserSignUp)

                call.enqueue(object : Callback<ResponseUserSignUp> {
                    override fun onResponse(
                        call: Call<ResponseUserSignUp>,
                        response: Response<ResponseUserSignUp>,
                    ) {

                        Log.d("get", "${response.body()}, ${response.code()}")
                    }

                    override fun onFailure(call: Call<ResponseUserSignUp>, t: Throwable) {
                        Log.d("get", "Error")
                    }

                })
            }
        }
    }
}