package com.example.ddaatapp.datamodel

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

data class AtmCardDataModel(
    val backgroundImage: Int,
    val cardLogo: Int,
    val cardNumber: String,
    val cardHolderName: String,
    val cardExpiryDate:String
)
