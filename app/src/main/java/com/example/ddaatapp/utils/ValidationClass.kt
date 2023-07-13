package com.example.ddaatapp.utils

import android.content.Context
import com.example.ddaatapp.`object`.Constants.EMAIL_PATTERN
import com.example.ddaatapp.`object`.Constants.MOBILE_PATTERN
import com.example.ddaatapp.`object`.Constants.PASSWORD_PATTERN
import java.util.regex.Pattern

/* EXTENSION FUNCTION*/

fun Context.validateEmail(input:String):Boolean{
   return Pattern.compile(EMAIL_PATTERN).matcher(input).matches()
}

fun Context.validateMobile(input:String):Boolean{
    return Pattern.compile(MOBILE_PATTERN).matcher(input).matches()
}

fun Context.validatePassword(input:String):Boolean{
    return Pattern.compile(PASSWORD_PATTERN).matcher(input).matches()
}

fun Context.validateConfPass(inputPwd:String,cnfPwd:String):Boolean{
    return inputPwd==cnfPwd
}




