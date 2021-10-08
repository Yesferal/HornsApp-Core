package com.yesferal.hornsapp.core.domain.common

import java.net.URI

actual class HaUri actual constructor(val value: String) {

    private val uri by lazy {
        URI(value)
    }

    actual fun getScheme(): String? {
        return uri.scheme
    }

    actual fun getHost() : String? {
        return uri.host
    }
}
