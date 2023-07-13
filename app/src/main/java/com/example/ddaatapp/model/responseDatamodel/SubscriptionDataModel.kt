package com.example.ddaatapp.model.responseDatamodel

data class SubscriptionDataModel(
    val isSubscribed: Boolean,
    val bg : Int,
    val symbol: Int,
    val planeName: String,
    val desc: String,
    val price: String,
    val subsInfo: String,
)
