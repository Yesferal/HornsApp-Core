/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.navigator.Parameters

data class ViewRender(
    private val key: String?,
    val data: DataRender?,
    val condition: ConditionRender?,
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
        ICON_HOME_CARD_VIEW,
        IMAGE_HOME_CARD_VIEW,
        AD_VIEW,
        TITLE_REVIEW_CARD_VIEW,
        SUBTITLE_REVIEW_CARD_VIEW,
        DESCRIPTION_REVIEW_CARD_VIEW,
        IMAGE_REVIEW_CARD_VIEW,
        BUTTON_CARD_VIEW,

        VISIBILITY_GONE_CARD_VIEW,
        UNDETERMINED
    }

    val type: Type
        get() {
            if (!shouldRender()) {
                return Type.VISIBILITY_GONE_CARD_VIEW
            }

            return when (key) {
                Type.NEWEST_FRAGMENT.name -> Type.NEWEST_FRAGMENT
                Type.UPCOMING_FRAGMENT.name -> Type.UPCOMING_FRAGMENT
                Type.FAVORITE_FRAGMENT.name -> Type.FAVORITE_FRAGMENT
                Type.CAROUSEL_VIEW.name -> Type.CAROUSEL_VIEW
                Type.VERTICAL_LIST_VIEW.name -> Type.VERTICAL_LIST_VIEW
                Type.ICON_HOME_CARD_VIEW.name -> Type.ICON_HOME_CARD_VIEW
                Type.IMAGE_HOME_CARD_VIEW.name -> Type.IMAGE_HOME_CARD_VIEW
                Type.AD_VIEW.name -> Type.AD_VIEW
                Type.TITLE_REVIEW_CARD_VIEW.name -> Type.TITLE_REVIEW_CARD_VIEW
                Type.SUBTITLE_REVIEW_CARD_VIEW.name -> Type.SUBTITLE_REVIEW_CARD_VIEW
                Type.DESCRIPTION_REVIEW_CARD_VIEW.name -> Type.DESCRIPTION_REVIEW_CARD_VIEW
                Type.IMAGE_REVIEW_CARD_VIEW.name -> Type.IMAGE_REVIEW_CARD_VIEW
                Type.BUTTON_CARD_VIEW.name -> Type.BUTTON_CARD_VIEW
                else -> Type.UNDETERMINED
            }
        }

    private fun shouldRender(): Boolean {
        return data?.visibility != false
    }
}
