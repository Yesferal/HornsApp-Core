/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedStringContract

interface CategoryRenderContract {
    val _id: String?
    val name: LocalizedStringContract?

    companion object {
        const val ALL = "ALL"
    }
}

data class CategoryRender(
    override val _id: String?,
    override val name: LocalizedStringContract?
) : CategoryRenderContract
