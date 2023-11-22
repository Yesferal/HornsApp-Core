/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ServerDrivenRepository

class GetReviewUseCase(
    private val serverDrivenRepository: ServerDrivenRepository
) {
    suspend operator fun invoke(
        id: String
    ) = serverDrivenRepository.getReview(id)
}
