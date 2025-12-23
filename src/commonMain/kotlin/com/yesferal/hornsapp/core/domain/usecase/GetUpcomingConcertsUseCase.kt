/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult

/**
 * This Use Case Provide the upcoming concerts
 * depending on a [CategoryRender.key]
 * and sorted by [Concert.timeInMillis]
 *
 * @author Yesferal
 */
class GetUpcomingConcertsUseCase(
    private val concertRepository: ConcertRepository,
    private val filterConcertsByCategoryUseCase: FilterConcertsByCategoryUseCase
) {
    suspend operator fun invoke(categoryKey: String): HaResult<List<Concert>> {
        return when (val result = concertRepository.getConcerts()) {
            is HaResult.Success -> {
                val filtered = filterConcertsByCategoryUseCase(result.value, categoryKey)
                    .sortedWith(compareBy {
                        it.timeInMillis
                    })

                HaResult.Success(filtered)
            }
            is HaResult.Error -> result
        }
    }
}
