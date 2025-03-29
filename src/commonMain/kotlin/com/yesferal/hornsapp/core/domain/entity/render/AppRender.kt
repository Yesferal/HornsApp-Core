/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

data class AppRender(
        val platform: String?,
        val docVersion: Long?,
        val appVersion: Long?,
        val screens: List<ViewRender>?,
        val views: List<ViewRender>?,
        val categories: List<ViewRender>?
)
