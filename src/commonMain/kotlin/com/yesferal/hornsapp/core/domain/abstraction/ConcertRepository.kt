package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.util.HaResult
import com.yesferal.hornsapp.core.domain.entity.Concert

interface ConcertRepository {
    suspend fun getConcerts(): HaResult<List<Concert>>

    suspend fun getConcert(
        id: String
    ): HaResult<Concert>

    suspend fun getFavoriteConcert(): List<Concert>

    suspend fun insertFavoriteConcert(
        concert: Concert
    )

    suspend fun removeFavoriteConcert(
        concert: Concert
    )
}
