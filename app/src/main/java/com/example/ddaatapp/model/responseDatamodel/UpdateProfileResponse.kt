package com.example.ddaatapp.model.responseDatamodel

data class UpdateProfileResponse(
    val success: Boolean,
    val message: String,
    val data: ProfileData
)
