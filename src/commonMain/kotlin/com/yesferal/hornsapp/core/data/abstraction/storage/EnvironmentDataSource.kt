package com.yesferal.hornsapp.core.data.abstraction.storage

interface EnvironmentDataSource {
    fun getDefaultEnvironment(): Int
    fun updateDefaultEnvironment(environment: Int)
    fun getEnvironments(): List<Pair<String, String>>
}
