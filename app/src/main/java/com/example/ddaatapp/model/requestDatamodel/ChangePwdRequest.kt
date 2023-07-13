package com.example.ddaatapp.model.requestDatamodel

data class ChangePwdRequest(
    val oldPwd: String,
    val newPwd: String,
    val cnfPwd: String, )
