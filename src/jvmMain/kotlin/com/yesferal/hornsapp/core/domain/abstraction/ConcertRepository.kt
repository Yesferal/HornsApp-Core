package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.common.Result
import com.yesferal.hornsapp.core.domain.entity.Concert

interface ConcertRepository {
    suspend fun getConcerts(): Result<List<Concert>>

    suspend fun getConcert(
        id: String
    ): Result<Concert>

    suspend fun getFavoriteConcert(): List<Concert>

    suspend fun insertFavoriteConcert(
        concert: Concert
    )

    suspend fun removeFavoriteConcert(
        concert: Concert
    )
}
