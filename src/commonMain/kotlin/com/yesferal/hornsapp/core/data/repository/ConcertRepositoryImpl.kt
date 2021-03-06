/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.storage.ConcertStorageDataSource
import com.yesferal.hornsapp.core.data.abstraction.remote.ConcertRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult

/**
 * This implement the interface [ConcertRepository]
 *
 * @author Yesferal
 */
class ConcertRepositoryImpl(
    private val concertStorageDataSource: ConcertStorageDataSource,
    private val concertRemoteDataSource: ConcertRemoteDataSource
) : ConcertRepository {

    override suspend fun getConcerts(): HaResult<List<Concert>> {
        return concertStorageDataSource.getConcertCached()?.let {
            HaResult.Success(it)
        } ?: run {
            val result = concertRemoteDataSource.getConcerts()
            if (result is HaResult.Success) {
                concertStorageDataSource.updateConcertCached(result.value)
            }
            result
        }
    }

    override suspend fun getConcert(
        id: String
    ): HaResult<Concert> = concertRemoteDataSource.getConcert(id)

    override suspend fun getFavoriteConcerts(): List<Concert> {
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
