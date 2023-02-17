package com.yesferal.hornsapp.core.domain.navigator

enum class ScreenType {
    SPLASH,
    ON_BOARDING,
    HOME,
    CONCERT_DETAIL,
    BAND_DETAIL,
    SETTING,
    PROFILE,
    NONE;

    fun asDirection(): Direction {
        return Direction.Build().to(this).build()
    }
}
