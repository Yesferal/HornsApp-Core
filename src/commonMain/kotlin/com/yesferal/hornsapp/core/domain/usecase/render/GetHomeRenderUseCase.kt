/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase.render

import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender

class GetHomeRenderUseCase(
    private val repository: RenderRepository
) {
    suspend operator fun invoke(): List<ScreenRender>? {
        return repository.getHomeRender()
    }
}
