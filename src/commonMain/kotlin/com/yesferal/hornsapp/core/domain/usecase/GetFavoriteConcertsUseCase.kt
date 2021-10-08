package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert

class GetFavoriteConcertsUseCase(
    private val concertRepository: ConcertRepository
) {
    suspend operator fun invoke() : List<Concert> {
        return concertRepository.getFavoriteConcert()
    }
}
