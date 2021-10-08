package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.util.HaResult
import com.yesferal.hornsapp.core.domain.entity.Concert

class GetConcertUseCase(
    private val concertRepository: ConcertRepository
) {
    suspend operator fun invoke(
        id: String
    ): HaResult<Concert> = concertRepository.getConcert(id)
}
