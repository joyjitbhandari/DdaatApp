package com.example.ddaatapp.model.responseDatamodel

data class OtpVerifyResponse(
    val message: String,
    val success: Boolean,
    val data: VerifyData,
)

data class VerifyData(
    val token: String,
    val data: String,
)

