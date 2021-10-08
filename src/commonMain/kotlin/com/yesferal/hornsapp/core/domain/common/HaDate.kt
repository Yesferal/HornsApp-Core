package com.yesferal.hornsapp.core.domain.common

expect class HaDate(value: String) {

    fun formattedWith(pattern: String): String?

    fun dateTimeFormatted(): String?

    fun dayFormatted(): String?

    fun monthFormatted(): String?

    fun yearFormatted(): String?

    fun timeFormatted(): String?
}
