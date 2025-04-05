/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.RenderRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender
import com.yesferal.hornsapp.core.domain.entity.render.ViewRender
import kotlinx.coroutines.flow.Flow

class RenderRepositoryImpl(private val renderRemoteDataSource: RenderRemoteDataSource): RenderRepository {

    override fun getHomeRender(): Flow<List<ScreenRender>> {
        return renderRemoteDataSource.homeRender
    }

    override fun getCategoryRender(): Flow<List<ViewRender>> {
        return renderRemoteDataSource.categoryRender
    }
}
