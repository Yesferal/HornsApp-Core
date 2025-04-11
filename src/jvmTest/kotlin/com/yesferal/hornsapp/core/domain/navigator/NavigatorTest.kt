/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [Navigator]
 *
 * @author Yesferal
 */
class NavigatorTest {

    private val parameters = Parameters().apply {
        put("id", "1234")
    }

    @Test
    fun given_aDirectionBuilder_withData_ThenGetDataFromResult() {
        // Given
        val directionBuilder = Navigator.Builder()
            .to(ScreenRender.Type.HOME_SCREEN)
            .with(parameters)

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenRender.Type.HOME_SCREEN, result.to)
        Assert.assertEquals(parameters, result.parameters)
        Assert.assertEquals(parameters.getString("id"), result.parameters?.getString("id"))
    }

    @Test
    fun given_aDirectionBuilder_withStringOrigin_ThenGetSameOriginFromResult() {
        // Given
        val directionBuilder = Navigator.Builder()
            .to("HOME_SCREEN")

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenRender.Type.HOME_SCREEN, result.to)
    }

    @Test
    fun given_aDirectionBuilder_withScreenTypeOrigin_ThenGetSameOriginFromResult() {
        // Given
        val directionBuilder = Navigator.Builder()
            .to(ScreenRender.Type.HOME_SCREEN)

        // When
        val result = directionBuilder.build()

        // Then
        Assert.assertEquals(ScreenRender.Type.HOME_SCREEN, result.to)
    }
}
