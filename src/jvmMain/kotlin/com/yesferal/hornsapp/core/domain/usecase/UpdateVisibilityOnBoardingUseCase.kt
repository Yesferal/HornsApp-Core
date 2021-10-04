package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.SettingsRepository

class UpdateVisibilityOnBoardingUseCase(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke() {
        settingsRepository.hideOnBoarding()
    }
}