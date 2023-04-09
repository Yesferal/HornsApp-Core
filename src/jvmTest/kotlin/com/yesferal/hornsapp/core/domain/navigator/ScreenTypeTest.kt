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
        val screenType = ScreenType.HOME

        // When
        val result = Navigator.Builder().to(screenType).build()

        // Then
        Assert.assertEquals(ScreenType.HOME, result.to)
    }
}