/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

interface StyleRenderContract {
    val width: Int?
    val height: Int?
    val textColor: String?
    val backgroundColor: String?
    val elevation: Boolean?
    val visibility: Boolean?
}

data class StyleRender(
    override val width: Int?,
    override val height: Int?,
    override val textColor: String?,
    override val backgroundColor: String?,
    override val elevation: Boolean?,
    override val visibility: Boolean?
) : StyleRenderContract
