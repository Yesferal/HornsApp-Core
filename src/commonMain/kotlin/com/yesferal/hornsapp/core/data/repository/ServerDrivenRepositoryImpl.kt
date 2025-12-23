/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.ReviewRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.ServerDrivenRepository
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract
import com.yesferal.hornsapp.core.domain.util.HaResult

class ServerDrivenRepositoryImpl(
    private val reviewRemoteDataSource: ReviewRemoteDataSource
): ServerDrivenRepository {
    override suspend fun getReview(id: String): HaResult<ScreenRenderContract> {
        return reviewRemoteDataSource.getReview(id)
    }
}
