package com.example.ddaatapp.model.requestDatamodel

data class OtpVerifyRequest(
    val name:String,
    val user_id: String,
    val password: String,
    val confirm_password: String,
    val otp: String,
    val email: String,
    val type: String,
    val mobile: String
    )
