package com.yesferal.hornsapp.core.domain.util

sealed class HaResult<out VALUE> {
    class Success<VALUE>(
            val value: VALUE
    ): HaResult<VALUE>()

    object Error : HaResult<Nothing>()
}
