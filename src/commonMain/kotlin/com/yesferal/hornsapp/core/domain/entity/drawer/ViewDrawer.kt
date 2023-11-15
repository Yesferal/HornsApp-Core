/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

import com.yesferal.hornsapp.core.domain.navigator.Parameters

data class ViewDrawer(
        private val key: String?,
        val data: DataDrawer?,
        val condition: ConditionDrawer?,
        val navigation: Parameters?,
) {
    enum class Type {
        // Fragments
        NEWEST_FRAGMENT,
        UPCOMING_FRAGMENT,
        FAVORITE_FRAGMENT,

        // Views
        CAROUSEL_VIEW,
        VERTICAL_LIST_VIEW,
        HOME_CARD_VIEW,
        AD_VIEW,

        UNDETERMINED
    }

    val type: Type
        get() = when (key) {
            Type.NEWEST_FRAGMENT.name -> Type.NEWEST_FRAGMENT
            Type.UPCOMING_FRAGMENT.name -> Type.UPCOMING_FRAGMENT
            Type.FAVORITE_FRAGMENT.name -> Type.FAVORITE_FRAGMENT
            Type.CAROUSEL_VIEW.name -> Type.CAROUSEL_VIEW
            Type.VERTICAL_LIST_VIEW.name -> Type.VERTICAL_LIST_VIEW
            Type.HOME_CARD_VIEW.name -> Type.HOME_CARD_VIEW
            Type.AD_VIEW.name -> Type.AD_VIEW
            else -> Type.UNDETERMINED
        }
}
