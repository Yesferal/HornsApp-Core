package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.SettingsRepository

class UpdateSettingsUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(environment: Int) {
        settingsRepository.updateDefaultEnvironment(environment)
    }
}