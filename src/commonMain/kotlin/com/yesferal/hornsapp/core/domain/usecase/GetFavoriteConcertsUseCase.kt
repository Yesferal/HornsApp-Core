/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert

/**
 * This Use Case Provide the favorites concerts
 * sorted by [Concert.timeInMillis]
 *
 * @author Yesferal
 */
class GetFavoriteConcertsUseCase(
    private val concertRepository: ConcertRepository
) {
    suspend operator fun invoke() : List<Concert> {
        return concertRepository.getFavoriteConcerts()
            .sortedWith(compareBy { it.timeInMillis })
    }
}
