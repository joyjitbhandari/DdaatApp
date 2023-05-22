package com.example.ddaatapp.postDatamodel

import android.text.Editable

data class PostUserSignUp(
    val name:String,
    val user_id: Int,
    val password: String,
    val confirm_password: String,
    val email: String?,
    val type: String,
    val mobile: Int?
    )
