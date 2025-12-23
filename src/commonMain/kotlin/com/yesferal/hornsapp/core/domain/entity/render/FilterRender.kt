/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

interface FilterRenderContract {
    val events: List<String>?
    val categories: List<String>?
}

data class FilterRender(
    override val events: List<String>?,
    override val categories: List<String>?
) : FilterRenderContract
