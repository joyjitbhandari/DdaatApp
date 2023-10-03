package com.example.ddaatapp.model.responseDatamodel

data class FaqListResponse(
    val `data`: List<FaqData>,
    val message: String,
    val success: Boolean
)
data class FaqData(
    val created_at: String,
    val description: String,
    val id: Int,
    val status: String,
    val title: String,
    val updated_at: String
)
