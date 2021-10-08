package com.yesferal.hornsapp.core.data.abstraction.storage

interface OnBoardingDataSource {
    fun onBoardingIsVisible() : Boolean
    fun hideOnBoarding()
}
