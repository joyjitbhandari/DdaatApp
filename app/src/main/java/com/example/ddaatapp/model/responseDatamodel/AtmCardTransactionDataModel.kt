package com.example.ddaatapp.model.responseDatamodel

data class AtmCardTransactionDataModel(
    val transSymbol : Int,
    val transName: String,
    val transReason: String,
    val amount: String,
    val date:String
)
