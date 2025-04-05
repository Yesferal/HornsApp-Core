/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender
import com.yesferal.hornsapp.core.domain.entity.render.ViewRender
import kotlinx.coroutines.flow.Flow

interface RenderRemoteDataSource {
    val homeRender: Flow<List<ScreenRender>>
    val categoryRender: Flow<List<ViewRender>>
}
