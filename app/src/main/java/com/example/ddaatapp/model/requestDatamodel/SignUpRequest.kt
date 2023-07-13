package com.example.ddaatapp.model.requestDatamodel

data class SignUpRequest(
    val name:String,
    val user_id: String,
    val password: String,
    val confirm_password: String,
    val email: String,
    val type: String,
    val mobile: String
    )
