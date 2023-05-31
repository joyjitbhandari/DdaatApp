package com.example.ddaatapp.responseDatamodel

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val `data`: LoginData,
)