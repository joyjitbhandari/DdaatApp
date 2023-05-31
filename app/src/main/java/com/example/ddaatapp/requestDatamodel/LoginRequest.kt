package com.example.ddaatapp.requestDatamodel

data class LoginRequest(
    val user_id: String,
    val password: String,
    val type: String,
    val mobile: String,
    val email: String,
    )
