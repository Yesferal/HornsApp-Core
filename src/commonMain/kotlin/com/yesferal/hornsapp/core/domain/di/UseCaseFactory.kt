/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.di

import com.yesferal.hornsapp.core.domain.abstraction.RenderRepository
import com.yesferal.hornsapp.core.domain.usecase.render.GetHomeRenderUseCase

/*
 Util class to handle Use Cases instance in iOS
 */
object UseCaseFactory {
    fun createGetHomeRenderUseCase(
        repository: RenderRepository
    ): GetHomeRenderUseCase {
        return GetHomeRenderUseCase(repository)
    }
}
