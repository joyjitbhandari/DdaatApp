package com.example.ddaatapp.utils

object Constants {
    //Urls
    const val BASE_URL = "https://dev-ddaat-admin.flynautstaging.com/api/"
    const val IMAGE_URL = "https://dev-ddaat-admin.flynautstaging.com/public/"

    //Tech Support Chat
    const val SEND_ID = "SEND_ID"
    const val RECEIVE_ID = "RECEIVE_ID"

    //Subscribe Flow
    const val  SUBSCRIPTION = "SUBSCRIPTION"
    //Unsubscribe Flow
    const val UNSUBSCRIBE = "UNSUBSCRIBE"

    //Stream Tab Layout
    const val TAB = "TAB"
    const val HOME = "HOME"

    // Operation Flow
    const val SIGN_UP = "SIGN_UP"
    const val FORGOT = "FORGOT"
    const val EDIT = "EDIT"
    const val ADD = "ADD"
    const val UPDATE = "UPDATE"
    const val LIVE = "LIVE"
    const val PODCAST = "PODCAST"
    const val VIDEO = "VIDEO"
    const val PURCHASED = "PURCHASED"
    const val COURSE = "COURSE"
    const val STREAM = "STREAM"

    //Patterns for input fields
    const val MOBILE_PATTERN = "^\\d{10}$" // Assumes a 10-digit mobile number
    const val EMAIL_PATTERN = "^[A-Za-z\\d+_.-]+@[A-Za-z\\d.-]+$"
    const val PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[A-Za-z0-9!@#\$%^&*]{8,16}\$"



}