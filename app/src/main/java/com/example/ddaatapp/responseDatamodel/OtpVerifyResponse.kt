package com.example.ddaatapp.responseDatamodel

data class OtpVerifyResponse(
    val message: String,
    val success: Boolean,
    val OTPData: OTPData

)