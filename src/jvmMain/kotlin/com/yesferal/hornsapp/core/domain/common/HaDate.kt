package com.yesferal.hornsapp.core.domain.common

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

actual class HaDate actual constructor(val time: Long?) {

    actual fun formattedWith(pattern: String): String? {
        if (time == null) {
            return null
        }

        return try {
            val date = Date(time)
            val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
            simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
            simpleDateFormat.format(date)
        } catch (e: Exception) {
            null
        }
    }

    actual fun dateTimeFormatted(): String? {
        return formattedWith("EEE dd, MMMM YYYY")
    }

    actual fun dayFormatted(): String? {
        return formattedWith("dd")
    }

    actual fun monthFormatted(): String? {
        return formattedWith("MMM")?.substring(0,3)
    }

    actual fun yearFormatted(): String? {
        return formattedWith("YYYY")
    }

    actual fun timeFormatted(): String? {
        return formattedWith("HH:mm a")
    }
}
