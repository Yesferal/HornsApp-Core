/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

interface ChildrenRenderContract {
    val key: String?
    val filter: FilterRenderContract?
    val sort: List<String>?
    val take: Int?

    enum class Type {
        CAROUSEL_CARD_VIEW,
        UPCOMING_CARD_VIEW,
        UPCOMING_IMAGE_CARD_VIEW,
        UNDETERMINED
    }

    val type: Type
        get() = when (key) {
            Type.CAROUSEL_CARD_VIEW.name -> Type.CAROUSEL_CARD_VIEW
            Type.UPCOMING_CARD_VIEW.name -> Type.UPCOMING_CARD_VIEW
            Type.UPCOMING_IMAGE_CARD_VIEW.name -> Type.UPCOMING_IMAGE_CARD_VIEW
            else -> Type.UNDETERMINED
        }
}

data class ChildrenRender(
    override val key: String?,
    override val filter: FilterRenderContract?,
    override val sort: List<String>?,
    override val take: Int?
) : ChildrenRenderContract
