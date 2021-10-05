package com.yesferal.hornsapp.core.domain.abstraction

import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

actual object Locator {
    actual fun language(): String {
        return NSLocale.currentLocale.languageCode
    }
}
