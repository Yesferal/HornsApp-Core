package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.Band
import com.yesferal.hornsapp.core.domain.common.Result

interface BandRemoteDataSource {
    suspend fun getBand(id: String): Result<Band>
}
