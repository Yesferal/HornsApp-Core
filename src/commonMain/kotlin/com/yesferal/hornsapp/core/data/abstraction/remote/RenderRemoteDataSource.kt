/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract
import kotlinx.coroutines.flow.Flow

interface RenderRemoteDataSource {
    val homeRender: Flow<List<ScreenRenderContract>>
    val categoryRender: Flow<List<CategoryRenderContract>>
}
