/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.RenderRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract
import kotlinx.coroutines.flow.Flow

class RenderRepositoryImpl(private val renderRemoteDataSource: RenderRemoteDataSource): RenderRepository {

    override fun getHomeRender(): Flow<List<ScreenRenderContract>> {
        return renderRemoteDataSource.homeRender
    }

    override fun getCategoryRender(): Flow<List<CategoryRenderContract>> {
        return renderRemoteDataSource.categoryRender
    }
}
