/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.entity.Lineup
import com.yesferal.hornsapp.core.domain.util.HaResult

interface LineupUseCase {
    suspend fun getLineup(id: String): HaResult<Lineup>
}
