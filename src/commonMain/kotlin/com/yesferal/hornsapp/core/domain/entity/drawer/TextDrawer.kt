package com.yesferal.hornsapp.core.domain.entity.drawer

import com.yesferal.hornsapp.core.domain.abstraction.Locator

data class TextDrawer(private val en: String?, private val es: String?) {
    val text: String?
        get() = when (Locator.language()) {
            "en" -> en
            "es" -> es
            else -> en
        }
}
