/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.RenderRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRender
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender

class RenderRepositoryImpl(private val renderRemoteDataSource: RenderRemoteDataSource): RenderRepository {
    override suspend fun getHomeRender(): List<ScreenRender>? {
        return renderRemoteDataSource.getHomeRender()
    }

    override suspend fun getCategoryRender(): List<CategoryRender>? {
        return renderRemoteDataSource.getCategoryRender()
    }
}
