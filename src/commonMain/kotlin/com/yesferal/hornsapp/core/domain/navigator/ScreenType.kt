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
    MAP,
    VIDEO,
    FAN_PAGE,
    WEB_VIEW,
    CALENDAR,
    MESSAGE,
    NONE;

    fun asDirection(navViewData: NavViewData? = null): Direction {
        return Direction.Build().to(this).with(navViewData).build()
    }
}
