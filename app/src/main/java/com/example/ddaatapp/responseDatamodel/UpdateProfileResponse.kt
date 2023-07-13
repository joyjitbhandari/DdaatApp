package com.example.ddaatapp.responseDatamodel

data class UpdateProfileResponse(
    val success: Boolean,
    val message: String,
    val data: ProfileData?
)
