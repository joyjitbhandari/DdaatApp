package com.example.ddaatapp.requestDatamodel

data class ChangePwdRequest(
    val oldPwd: String,
    val newPwd: String,
    val cnfPwd: String, )
