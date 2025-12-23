/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract
import kotlinx.coroutines.flow.Flow

interface RenderRepository {
    fun getHomeRender(): Flow<List<ScreenRenderContract>>
    fun getCategoryRender(): Flow<List<CategoryRenderContract>>
}
