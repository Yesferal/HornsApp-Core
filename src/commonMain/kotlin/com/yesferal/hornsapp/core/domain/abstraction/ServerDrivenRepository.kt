/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.drawer.ScreenRender
import com.yesferal.hornsapp.core.domain.util.HaResult

interface ServerDrivenRepository {
    suspend fun getReview(
        id: String
    ): HaResult<ScreenRender>
}
