/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

import com.yesferal.hornsapp.core.MockitoTest
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [ViewDrawer]
 *
 * @author Yesferal
 */
class ViewDrawerTest : MockitoTest {

    private lateinit var viewDrawer: ViewDrawer

    @Test
    fun givenViewDrawer_WhenThereIsNotData_ThenShouldRenderTrue() {
        // Given
        val data = null

        // When
        viewDrawer = ViewDrawer("", data, null, null)

        // Then
        Assert.assertEquals(true, viewDrawer.shouldRender())
    }

    @Test
    fun givenViewDrawer_WhenThereIsNotVisibility_ThenShouldRenderTrue() {
        // Given
        val data = DataDrawer(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = null
        )

        // When
        viewDrawer = ViewDrawer("", data, null, null)

        // Then
        Assert.assertEquals(true, viewDrawer.shouldRender())
    }

    @Test
    fun givenViewDrawer_WhenThereIsTrueVisibility_ThenShouldRenderTrue() {
        // Given
        val data = DataDrawer(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = true
        )

        // When
        viewDrawer = ViewDrawer("", data, null, null)

        // Then
        Assert.assertEquals(true, viewDrawer.shouldRender())
    }

    @Test
    fun givenViewDrawer_WhenThereIsFalseVisibility_ThenShouldRenderTrue() {
        // Given
        val data = DataDrawer(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = false
        )

        // When
        viewDrawer = ViewDrawer("", data, null, null)

        // Then
        Assert.assertEquals(false, viewDrawer.shouldRender())
    }
}
