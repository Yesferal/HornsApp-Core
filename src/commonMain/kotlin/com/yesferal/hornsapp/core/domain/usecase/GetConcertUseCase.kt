package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.util.HaResult
import com.yesferal.hornsapp.core.domain.entity.Concert

class GetConcertUseCase(
    private val concertRepository: ConcertRepository,
    private val getFavoriteConcertsUseCase: GetFavoriteConcertsUseCase,
) {
    suspend operator fun invoke(
        id: String
    ): HaResult<Concert> {
        return when (val result = concertRepository.getConcert(id)) {
            is HaResult.Success -> {
                getFavoriteConcertsUseCase()
                    .map { it.id }
                    .let { favorites ->
                        if (favorites.contains(result.value.id)) {
                            result.value.isFavorite = true
                        }
                    }
                result
            }
            else -> result
        }
    }
}
