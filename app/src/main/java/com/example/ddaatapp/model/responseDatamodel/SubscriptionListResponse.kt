package com.example.ddaatapp.model.responseDatamodel

data class SubscriptionListResponse(
    val success: Boolean,
    val message: String,
    val `data`: List<SubscriptionData>
)
data class SubscriptionData(
    val id: Int,
    val subscription_name: String,
    val price: String,
    val feature: String,
    val status: String,
    val created_at: String,
    val updated_at: String
)