package com.example.ddaatapp.postDatamodel

import android.text.Editable

data class PostOtpVerify(
    val name:String,
    val user_id: String,
    val password: String,
    val confirm_password: String,
    val otp: String,
    val email: String,
    val type: String,
    val mobile: String
    )
