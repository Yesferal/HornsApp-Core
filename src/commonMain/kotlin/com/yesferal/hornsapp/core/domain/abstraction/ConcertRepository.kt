/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.util.HaResult
import com.yesferal.hornsapp.core.domain.entity.Concert

/**
 * This interface is a contract to handle [Concert] entity
 *
 * @author Yesferal
 */
interface ConcertRepository {
    suspend fun getConcerts(): HaResult<List<Concert>>

    suspend fun getConcert(
        id: String
    ): HaResult<Concert>

    suspend fun getFavoriteConcerts(): List<Concert>

    suspend fun insertFavoriteConcert(
        concert: Concert
    )

    suspend fun removeFavoriteConcert(
        concert: Concert
    )
}
