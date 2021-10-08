package com.yesferal.hornsapp.core.domain.common

expect class HaDate(time: Long?) {

    fun formattedWith(pattern: String): String?

    fun dateTimeFormatted(): String?

    fun dayFormatted(): String?

    fun monthFormatted(): String?

    fun yearFormatted(): String?

    fun timeFormatted(): String?
}
