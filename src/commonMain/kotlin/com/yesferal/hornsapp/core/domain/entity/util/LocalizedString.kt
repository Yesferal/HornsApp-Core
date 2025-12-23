/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.util

import com.yesferal.hornsapp.core.domain.common.Locator

interface LocalizedStringContract {
    val en: String?
    val es: String?
    val text: String?
        get() = when (Locator.language()) {
            "en" -> en
            "es" -> {
                es ?: en
            }
            else -> en
        }
}

data class LocalizedString(
    override val en: String?,
    override val es: String?
) : LocalizedStringContract
