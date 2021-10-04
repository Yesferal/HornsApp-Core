package com.yesferal.hornsapp.core.domain.common

sealed class Result<out VALUE> {
    class Success<VALUE>(
            val value: VALUE
    ): Result<VALUE>()

    object Error : Result<Nothing>()
}
