/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [ScreenRender.Type]
 *
 * @author Yesferal
 */
class ScreenTypeTest {
    @Test
    fun givenAnScreenType_WhenParseAsDirection_ThenResultShouldContainsType() {
        // Given
        val screenType = ScreenRender.Type.HOME_SCREEN

        // When
        val result = Navigator.Builder().to(screenType).build()

        // Then
        Assert.assertEquals(ScreenRender.Type.HOME_SCREEN, result.to)
    }
}