package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.Band
import com.yesferal.hornsapp.core.domain.common.Result

interface BandRepository {
    suspend fun getBand(
        id: String
    ): Result<Band>
}
