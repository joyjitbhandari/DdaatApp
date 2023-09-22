package com.example.ddaatapp.model.responseDatamodel

data class CategoryList(
    val `data`: List<CategoryData>,
    val message: String,
    val success: Boolean
)
data class CategoryData(
    val created_at: String,
    val description: String,
    val id: Int,
    val image: String,
    val meta_description: String,
    val meta_keyword: String,
    val meta_title: String,
    val name: String,
    val status: String,
    val updated_at: String
)
