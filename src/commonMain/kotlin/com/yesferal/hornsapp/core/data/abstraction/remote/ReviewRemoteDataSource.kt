/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract
import com.yesferal.hornsapp.core.domain.util.HaResult

interface ReviewRemoteDataSource {
    suspend fun getReview(id: String): HaResult<ScreenRenderContract>
}
