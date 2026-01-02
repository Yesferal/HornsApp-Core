/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.render.CategoryRender
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender

interface RenderRemoteDataSource {
    suspend fun getHomeRender(): List<ScreenRender>?
    suspend fun getCategoryRender(): List<CategoryRender>?
}
