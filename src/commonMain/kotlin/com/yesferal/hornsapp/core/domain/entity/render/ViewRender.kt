/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

data class ViewRender(
    private val key: String?,
    val data: DataRender?,
    val style: StyleRender?,
    val children: ChildrenRender?,
    val navigation: NavigatorRender?,
) {
    enum class Type {
        // Views
        ROW_VIEW,
        COLUMN_VIEW,
        CARD_VIEW,
        ICON_CARD_VIEW,
        AD_VIEW,
        CAROUSEL_VIEW,

        // Review
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
                Type.ROW_VIEW.name -> Type.ROW_VIEW
                Type.COLUMN_VIEW.name -> Type.COLUMN_VIEW
                Type.CARD_VIEW.name -> Type.CARD_VIEW
                Type.ICON_CARD_VIEW.name -> Type.ICON_CARD_VIEW
                Type.AD_VIEW.name -> Type.AD_VIEW
                Type.CAROUSEL_VIEW.name -> Type.CAROUSEL_VIEW

                Type.TITLE_REVIEW_CARD_VIEW.name -> Type.TITLE_REVIEW_CARD_VIEW
                Type.SUBTITLE_REVIEW_CARD_VIEW.name -> Type.SUBTITLE_REVIEW_CARD_VIEW
                Type.DESCRIPTION_REVIEW_CARD_VIEW.name -> Type.DESCRIPTION_REVIEW_CARD_VIEW
                Type.IMAGE_REVIEW_CARD_VIEW.name -> Type.IMAGE_REVIEW_CARD_VIEW
                Type.BUTTON_CARD_VIEW.name -> Type.BUTTON_CARD_VIEW

                else -> Type.UNDETERMINED
            }
        }

    private fun shouldRender(): Boolean {
        return style?.visibility != false
    }
}
