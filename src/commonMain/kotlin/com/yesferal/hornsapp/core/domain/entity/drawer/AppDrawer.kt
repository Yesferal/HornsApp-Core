/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

data class AppDrawer(
        val screens: List<ViewDrawer>?,
        val newest: List<ViewDrawer>?,
        val categories: List<ViewDrawer>?
)
