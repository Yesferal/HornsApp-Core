package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.BandRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.BandRepository

class BandRepositoryImpl(
    private val bandRemoteDataSource: BandRemoteDataSource
) : BandRepository {

    override suspend fun getBand(
        id: String
    ) = bandRemoteDataSource.getBand(id)
}
