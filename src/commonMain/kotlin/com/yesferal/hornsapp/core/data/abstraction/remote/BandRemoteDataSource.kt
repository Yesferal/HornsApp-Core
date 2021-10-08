package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.Band
import com.yesferal.hornsapp.core.domain.util.HaResult

interface BandRemoteDataSource {
    suspend fun getBand(id: String): HaResult<Band>
}
