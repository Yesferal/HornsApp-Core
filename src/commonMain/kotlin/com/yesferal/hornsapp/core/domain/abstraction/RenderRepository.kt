/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender
import com.yesferal.hornsapp.core.domain.entity.render.ViewRender
import kotlinx.coroutines.flow.Flow

interface RenderRepository {
    fun getHomeRender(): Flow<List<ScreenRender>>
    fun getCategoryRender(): Flow<List<ViewRender>>
}
