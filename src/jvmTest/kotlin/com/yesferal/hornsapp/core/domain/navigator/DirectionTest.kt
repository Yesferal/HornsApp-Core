/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import org.junit.Assert
import org.junit.Test

/**
 * This class will test [Direction]
 *
 * @author Yesferal
 */
class DirectionTest {

    private val navViewData = object : NavViewData {
        override val id: String = "1234"
        override val name: String? = null
    }

    @Test
    fun given_aDirectionBuilder_withData_ThenGetDataFromResult() {
        // Given
        val directionBuilder = Direction.Build()
            .to(ScreenType.HOME)
            .with(navViewData)

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenType.HOME, result.to)
        Assert.assertEquals(navViewData, result.parameter)
        Assert.assertEquals(navViewData.id, result.parameter?.id)
    }

    @Test
    fun given_aDirectionBuilder_withStringOrigin_ThenGetSameOriginFromResult() {
        // Given
        val directionBuilder = Direction.Build()
            .to("HOME")

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenType.HOME, result.to)
    }

    @Test
    fun given_aDirectionBuilder_withScreenTypeOrigin_ThenGetSameOriginFromResult() {
        // Given
        val directionBuilder = Direction.Build()
            .to(ScreenType.HOME)

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenType.HOME, result.to)
    }
}
