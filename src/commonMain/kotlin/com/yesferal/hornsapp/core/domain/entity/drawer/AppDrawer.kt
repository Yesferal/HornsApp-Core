package com.yesferal.hornsapp.core.domain.entity.drawer

data class AppDrawer(
    val screens: List<ScreenDrawer>?,
    val newest: List<ScreenDrawer>?,
    val categories: List<CategoryDrawer>?
)
