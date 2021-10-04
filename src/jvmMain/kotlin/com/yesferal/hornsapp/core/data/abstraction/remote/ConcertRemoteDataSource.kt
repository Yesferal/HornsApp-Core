package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.common.Result

interface ConcertRemoteDataSource {
    suspend fun getConcerts(): Result<List<Concert>>
    suspend fun getConcert(id: String): Result<Concert>
}
