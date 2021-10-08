package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult

interface ConcertRemoteDataSource {
    suspend fun getConcerts(): HaResult<List<Concert>>
    suspend fun getConcert(id: String): HaResult<Concert>
}
