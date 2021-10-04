package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.SettingsRepository

class GetDefaultEnvironmentUseCase(
        private val settingsRepository: SettingsRepository
) {
    operator fun invoke() = settingsRepository.getDefaultEnvironment()
}