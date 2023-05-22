package com.example.ddaatapp.activity.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.activity.otpvrify.OtpVerifyActivity
import com.example.ddaatapp.databinding.ActivitySignUpBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.postDatamodel.PostUserSignUp
import com.example.ddaatapp.responseDatamodel.ResponseUserSignUp
import com.example.ddaatapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var type : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }



    override fun onClick(view: View?) {
        when(view){

            binding.signupBtn->{val operationFlow = Constants.SIGN_UP

                if (CheckAllFields()) {
                    val intent = Intent(this, OtpVerifyActivity::class.java)
                    intent.putExtra("operation",operationFlow)
                    startActivity(intent)

                    postSignUp(PostUserSignUp( "joyjit",12346,"1234","1234",null,"mobile",1234567890))

                }



//                val name = binding.etName.text
//                val userId = binding.etUserId.text
//                val password = binding.etPwd.text
//                val cnfPwd = binding.etCnfPwd.text
//                val emailMob = binding.etEmail.text

//                if (emailMob != null) {
//                    if(emailMob.contains("@gmail.com")) {
//                        postSignUp(PostUserSignUp( name.toString(), userId,password.toString(),cnfPwd.toString(),emailMob.toString(),"email",null))
//                    }else{
//                        postSignUp(PostUserSignUp( name.toString(), userId,password.toString(),cnfPwd.toString(),null,"mobile",emailMob))
//                    }
//                }

            }
        }

    }
    private fun postSignUp(postUserSignUp: PostUserSignUp) {
        val call =  RetrofitInstance.apiServices.userSignup(postUserSignUp)

        call.enqueue(object : Callback<ResponseUserSignUp>{
            override fun onResponse(
                call: Call<ResponseUserSignUp>,
                response: Response<ResponseUserSignUp>,
            ) {

                Log.d("get", "${response.body()}")
            }

            override fun onFailure(call: Call<ResponseUserSignUp>, t: Throwable) {
                Toast.makeText(this@SignUpActivity, "Error Occurred", Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun CheckAllFields(): Boolean {
        if (binding.etName.length() === 0) {
            binding.etName.error = "This field is required"
            return false
        }
//        if (etLastName.length() === 0) {
//            etLastName.setError("This field is required")
//            return false
//        }
//        if (etEmail.length() === 0) {
//            etEmail.setError("Email is required")
//            return false
//        }
//        if (etPassword.length() === 0) {
//            etPassword.setError("Password is required")
//            return false
//        } else if (etPassword.length() < 16) {
//            etPassword.setError("Password must be minimum 16 characters")
//            return false
//        }

        // after all validation return true.
        return true
    }

    private fun validateEmailInput(input: String?): Boolean {
        // Regex patterns for mobile number and email validation
        val mobilePattern = "^\\d{10}$" // Assumes a 10-digit mobile number
        val emailPattern = "^[A-Za-z\\d+_.-]+@[A-Za-z\\d.-]+$"

        // Check if input matches either the mobile number or email pattern
        val patternMobile: Pattern = Pattern.compile(mobilePattern)
        val patternEmail: Pattern = Pattern.compile(emailPattern)
        val matcherMobile: Matcher = patternMobile.matcher(input)
        val matcherEmail: Matcher = patternEmail.matcher(input)
        return matcherMobile.matches() || matcherEmail.matches()
    }
}