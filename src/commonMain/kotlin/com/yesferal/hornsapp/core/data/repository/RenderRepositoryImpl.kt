/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.RenderRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.entity.render.ViewRender
import kotlinx.coroutines.flow.Flow

class RenderRepositoryImpl(private val renderRemoteDataSource: RenderRemoteDataSource): RenderRepository {

    override fun getHomeRender(): Flow<List<ViewRender>> {
        return renderRemoteDataSource.homeRender
    }

    override fun getNewestRender(): Flow<List<ViewRender>> {
        return renderRemoteDataSource.newestRender
    }

    override fun getCategoryRender(): Flow<List<ViewRender>> {
        return renderRemoteDataSource.categoryRender
    }
}
