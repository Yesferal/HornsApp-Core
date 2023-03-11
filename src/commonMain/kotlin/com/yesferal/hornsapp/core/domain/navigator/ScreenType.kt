package com.yesferal.hornsapp.core.domain.navigator

enum class ScreenType {
    SPLASH,
    ON_BOARDING,
    HOME,
    NEWEST,
    UPCOMING,
    FAVORITE,
    CONCERT_DETAIL,
    BAND_DETAIL,
    SETTING,
    PROFILE,
    VIDEO,
    FAN_PAGE,
    MAP,
    WEB_VIEW,
    NONE;

    fun asDirection(navViewData: NavViewData? = null): Direction {
        return Direction.Build().to(this).with(navViewData).build()
    }
}
