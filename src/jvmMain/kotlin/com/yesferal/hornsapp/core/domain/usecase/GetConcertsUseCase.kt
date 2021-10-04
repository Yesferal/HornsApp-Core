package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository

class GetConcertsUseCase(
    private val concertRepository: ConcertRepository
) {
    suspend operator fun invoke() = concertRepository.getConcerts()
}