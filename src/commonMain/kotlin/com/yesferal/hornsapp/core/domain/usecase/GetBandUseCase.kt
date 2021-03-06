package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.BandRepository

class GetBandUseCase(
    private val bandRepository: BandRepository
) {
    suspend operator fun invoke(
        id: String
    ) = bandRepository.getBand(id)
}
