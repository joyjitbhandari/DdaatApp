package com.example.ddaatapp.datamodel

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

data class ArticleDataModel(
    val drawable: Int,
    val articleName:String,
    val articleDesc: String,
    val artileDate: String,
    val articleAuthor:String
)
