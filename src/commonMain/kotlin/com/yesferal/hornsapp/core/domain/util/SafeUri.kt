package com.yesferal.hornsapp.core.domain.util

import com.yesferal.hornsapp.core.domain.common.HaUri

class SafeUri(private val value: String?) {

    private fun isSafe(haUri: HaUri): Boolean {
        val allowedHosts = listOf(
            "www.facebook.com",
            "www.joinnus.com",
            "www.youtube.com",
            "www.teleticket.com.pe",
            "www.fuzzpass.com",
            "www.eventrid.pe"
        )
        val allowedScheme = "https"

        var isSafe = false
        if (allowedScheme == haUri.getScheme()
            && allowedHosts.contains(haUri.getHost())
        ) {
            isSafe = true
        }

        return isSafe
    }

    fun getAbsoluteUri(): String? {
        if (value == null) {
            return null
        }

        val haUri = HaUri(value)

        return if (isSafe(haUri)) {
            value
        } else {
            null
        }
    }
}
