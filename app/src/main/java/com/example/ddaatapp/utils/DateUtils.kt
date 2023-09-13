package com.example.ddaatapp.utils

import java.text.SimpleDateFormat
import java.util.TimeZone

object DateUtils {
  fun convertUtcToCustomFormat(utcDateString: String, targetFormat: String): String {
          try {
              val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'")
              inputFormat.timeZone = TimeZone.getTimeZone("UTC")

              val outputFormat = SimpleDateFormat(targetFormat)
              val date = inputFormat.parse(utcDateString)
              return outputFormat.format(date)
          } catch (e: Exception) {
              e.printStackTrace()
              return ""
          }
    }
}

object DateFormat {
    const val DATE_FORMAT = "dd-MM-yyyy"
    const val DATE_TIME_FORMAT = "dd MMM yyyy · hh:mm a"
    const val TIME_FORMAT = "hh:mm a"
    const val TIME_FORMAT_24 = "HH:mm"
    const val MON_YEAR_FORMAT = "dd MMM, yyyy"
    const val MON_DAY_YEAR = "MMM dd, yyyy"
    const val MON_DATE = "MMM dd"
    const val MON_DATE_YEAR = "MMM dd, yy"
    const val DATE_FORMAT_SLASH = "MM/dd/yy"
    const val DATE_FORMAT_SLASH_YEAR = "dd/MM/yyyy"
    const val DATE_FORMAT_RENEW = "yyyy-MM-dd hh:mm"
    const val UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val UTC_FORMAT_NORMAL = "yyyy-MM-dd hh:mm:ss"
    const val MONTH_FORMAT = "MMM"
    const val HH_24 = "HH"
    const val MM = "mm"
}