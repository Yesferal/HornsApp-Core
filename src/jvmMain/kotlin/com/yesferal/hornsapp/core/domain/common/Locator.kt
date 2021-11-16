package com.yesferal.hornsapp.core.domain.common

import java.util.*

actual object Locator {
    @JvmStatic
    actual fun language(): String = Locale.getDefault().language
}
