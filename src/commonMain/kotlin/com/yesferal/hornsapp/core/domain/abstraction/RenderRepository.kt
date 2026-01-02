/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.render.CategoryRender
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender

interface RenderRepository {
    suspend fun getHomeRender(): List<ScreenRender>?
    suspend fun getCategoryRender(): List<CategoryRender>?
}
