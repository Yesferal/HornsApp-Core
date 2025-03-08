/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.util

import com.yesferal.hornsapp.core.domain.common.Locator

data class LocalizedString(private val en: String?, private val es: String?) {
    val text: String?
        get() = when (Locator.language()) {
            "en" -> en
            "es" -> es
            else -> en
        }
}
