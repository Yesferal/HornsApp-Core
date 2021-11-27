/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import org.junit.Assert
import org.junit.Test

/**
 * This class will test [ScreenType]
 *
 * @author Yesferal
 */
class ScreenTypeTest {
    @Test
    fun givenAnScreenType_WhenParseAsDirection_ThenResultShouldContainsType() {
        // Given
        val screenType = ScreenType.Home

        // When
        val result = screenType.asDirection()

        // Then
        Assert.assertEquals(ScreenType.Home, result.to)
    }
}