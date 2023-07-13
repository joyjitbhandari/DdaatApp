package com.example.ddaatapp.model.responseDatamodel

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val `data`: ProfileData?,
)

data class ProfileData(
    val id: Int,
    val name: String,
    val email: String,
    val token: String,
    val mobile: String,
    val email_verified_at: String,
    val users_id: String,
    val birth_year: String,
    val device_key: String,
    val gender: String,
    val profile: String,
    val subscription_id: String,
    val social_type: String,
    val social_id: String,
    val created_at: String,
    val updated_at: String,
    val category: List<Category>,
)

data class Category(
    val frontuser_id: String,
    val category_name: String,
    val category_id: String,
)
