package com.yesferal.hornsapp.core.domain.abstraction

interface SettingsRepository {
    val screenDelay: Long
    fun getEnvironments(): List<Pair<String, String>>
    fun getDefaultEnvironment(): Int
    fun updateDefaultEnvironment(environment: Int)
    fun onBoardingIsVisible() : Boolean
    fun hideOnBoarding()
}
