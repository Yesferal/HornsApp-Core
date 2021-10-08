package com.yesferal.hornsapp.core.domain.common

expect class HaUri(value: String) {
    fun getScheme(): String?
    fun getHost(): String?
}
