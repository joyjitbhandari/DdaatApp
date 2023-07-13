package com.example.ddaatapp.model.responseDatamodel

data class ReviewAndRatingDataModel(
    val drawable : Int,
    val mentorName: String,
    val dateTime: String,
    val rating: Int,
    val ratingBody: String
)
