package com.example.ddaatapp.datamodel

data class SubscriptionDataModel(
    val isSubscribed: Boolean,
    val bg : Int,
    val symbol: Int,
    val planeName: String,
    val desc: String,
    val price: String,
    val subsInfo: String,
)
