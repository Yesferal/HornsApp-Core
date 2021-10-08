package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.storage.ConcertStorageDataSource
import com.yesferal.hornsapp.core.data.abstraction.remote.ConcertRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult

class ConcertRepositoryImpl(
    private val concertStorageDataSource: ConcertStorageDataSource,
    private val concertRemoteDataSource: ConcertRemoteDataSource
) : ConcertRepository {
    var concerts: List<Concert>? = null

    override suspend fun getConcerts(): HaResult<List<Concert>> {
        return concerts?.let {
            HaResult.Success(it)
        } ?: run {
            val result = concertRemoteDataSource.getConcerts()
            if (result is HaResult.Success) {
                concerts = result.value
            }
            result
        }
    }

    override suspend fun getConcert(
        id: String
    ): HaResult<Concert> = concertRemoteDataSource.getConcert(id)

    override suspend fun getFavoriteConcert(): List<Concert> {
        return concertStorageDataSource.getFavoriteConcerts()
    }

    override suspend fun insertFavoriteConcert(
        concert: Concert
    ) {
        concertStorageDataSource.insertFavoriteConcert(concert)
    }

    override suspend fun removeFavoriteConcert(
        concert: Concert
    ) {
        concertStorageDataSource.removeFavoriteConcert(concert)
    }
}
