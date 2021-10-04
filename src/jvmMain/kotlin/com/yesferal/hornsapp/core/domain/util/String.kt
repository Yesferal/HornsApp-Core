package com.yesferal.hornsapp.core.domain.util

import java.net.URI

fun String.toSafeUri(): URI? {
    val uri = URI(this)

    return if (uri.isSafe()) {
        uri
    } else {
        null
    }
}