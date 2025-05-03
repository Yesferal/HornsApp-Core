/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedString

data class CategoryRender(
    val _id: String?,
    val name: LocalizedString?,
) {
    companion object {
        const val ALL = "ALL"
    }
}
