package com.example.ddaatapp.model.responseDatamodel

data class BlogDetails(
    val success: Boolean,
    val `data`: BlogData,
    val message: String,
)