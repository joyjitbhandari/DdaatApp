package com.example.ddaatapp.model.responseDatamodel

data class BlogListResponse(
    val `data`: List<BlogData>,
    val message: String,
    val success: Boolean
)

data class BlogData(
    val created_at: String,
    val description: String,
    val id: Int,
    val image: String,
    val status: String,
    val title: String,
    val updated_at: String
)