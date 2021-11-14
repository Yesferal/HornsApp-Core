package com.yesferal.hornsapp.core.domain.navigator

enum class ScreenType {
    Splash,
    OnBoarding,
    Home,
    ConcertDetail,
    BandDetail,
    Setting,
    Profile,
    None;

    fun asDirection(): Direction {
        return Direction.Build().to(this).build()
    }
}
