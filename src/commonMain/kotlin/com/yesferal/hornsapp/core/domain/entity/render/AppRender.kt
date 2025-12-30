/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

interface AppRenderContract {
        val platform: String?
        val appId: String?
        val docVersion: Long?
        val appVersion: Long?
        val screens: List<ScreenRenderContract>?
        val categories: List<CategoryRenderContract>?
}

data class AppRender(
        override val platform: String?,
        override val appId: String?,
        override val docVersion: Long?,
        override val appVersion: Long?,
        override val screens: List<ScreenRenderContract>?,
        override val categories: List<CategoryRenderContract>?
) : AppRenderContract
