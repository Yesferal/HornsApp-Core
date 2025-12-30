/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedString

data class ScreenRender(
    private val key: String?,
    val _id: String?,
    val title: LocalizedString?,
    val views: List<ViewRender>?,
    val visibility: Boolean?,
) {
    enum class Type {
        SPLASH_SCREEN,
        ON_BOARDING_SCREEN,
        HOME_SCREEN,
        NEWEST_SCREEN,
        UPCOMING_SCREEN,
        FAVORITE_SCREEN,
        CONCERT_DETAIL_SCREEN,
        BAND_DETAIL_SCREEN,
        SETTING_SCREEN,
        PROFILE_SCREEN,
        MAP_SCREEN,
        VIDEO_SCREEN,
        FAN_PAGE_SCREEN,
        WEB_VIEW_SCREEN,
        CALENDAR_SCREEN,
        MESSAGE_SCREEN,
        RENDER_SCREEN,
        LINEUP_SCREEN,
        STAGE_LINEUP_SCREEN,

        VISIBILITY_GONE_SCREEN,
        UNDETERMINED_SCREEN
    }

    val type: Type
        get() {
            if (!shouldRender()) {
                return Type.VISIBILITY_GONE_SCREEN
            }

            return when (key) {
                Type.SPLASH_SCREEN.name -> Type.SPLASH_SCREEN
                Type.ON_BOARDING_SCREEN.name -> Type.ON_BOARDING_SCREEN
                Type.HOME_SCREEN.name -> Type.HOME_SCREEN
                Type.NEWEST_SCREEN.name -> Type.NEWEST_SCREEN
                Type.UPCOMING_SCREEN.name -> Type.UPCOMING_SCREEN
                Type.FAVORITE_SCREEN.name -> Type.FAVORITE_SCREEN
                Type.CONCERT_DETAIL_SCREEN.name -> Type.CONCERT_DETAIL_SCREEN
                Type.BAND_DETAIL_SCREEN.name -> Type.BAND_DETAIL_SCREEN
                Type.SETTING_SCREEN.name -> Type.SETTING_SCREEN
                Type.PROFILE_SCREEN.name -> Type.PROFILE_SCREEN
                Type.MAP_SCREEN.name -> Type.MAP_SCREEN
                Type.VIDEO_SCREEN.name -> Type.VIDEO_SCREEN
                Type.FAN_PAGE_SCREEN.name -> Type.FAN_PAGE_SCREEN
                Type.WEB_VIEW_SCREEN.name -> Type.WEB_VIEW_SCREEN
                Type.CALENDAR_SCREEN.name -> Type.CALENDAR_SCREEN
                Type.MESSAGE_SCREEN.name -> Type.MESSAGE_SCREEN
                Type.RENDER_SCREEN.name -> Type.RENDER_SCREEN
                Type.LINEUP_SCREEN.name -> Type.LINEUP_SCREEN
                Type.STAGE_LINEUP_SCREEN.name -> Type.STAGE_LINEUP_SCREEN

                else -> Type.UNDETERMINED_SCREEN
            }
        }

    private fun shouldRender(): Boolean {
        return visibility != false
    }
}
