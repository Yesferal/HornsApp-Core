package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.storage.EnvironmentDataSource
import com.yesferal.hornsapp.core.data.abstraction.storage.OnBoardingDataSource
import com.yesferal.hornsapp.core.domain.abstraction.SettingsRepository

class SettingsRepositoryImpl(
    private val environmentDataSource: EnvironmentDataSource,
    private val onBoardingDataSource: OnBoardingDataSource
) : SettingsRepository {
    override val screenDelay: Long
        get() = 300

    override fun getEnvironments() = environmentDataSource.getEnvironments()

    override fun getDefaultEnvironment() = environmentDataSource.getDefaultEnvironment()

    override fun updateDefaultEnvironment(environment: Int) {
        environmentDataSource.updateDefaultEnvironment(environment)
    }

    override fun onBoardingIsVisible(): Boolean {
        return onBoardingDataSource.onBoardingIsVisible()
    }

    override fun hideOnBoarding() {
        return onBoardingDataSource.hideOnBoarding()
    }
}
