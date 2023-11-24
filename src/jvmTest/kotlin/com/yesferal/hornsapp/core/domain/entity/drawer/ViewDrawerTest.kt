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
        val key = ViewDrawer.Type.NEWEST_FRAGMENT
        val data = null

        // When
        viewDrawer = ViewDrawer(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewDrawer.type)
    }

    @Test
    fun givenViewDrawer_WhenThereIsNotVisibility_ThenShouldRenderTrue() {
        // Given
        val key = ViewDrawer.Type.NEWEST_FRAGMENT
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
        viewDrawer = ViewDrawer(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewDrawer.type)
    }

    @Test
    fun givenViewDrawer_WhenThereIsTrueVisibility_ThenShouldRenderTrue() {
        // Given
        val key = ViewDrawer.Type.NEWEST_FRAGMENT
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
        viewDrawer = ViewDrawer(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewDrawer.type)
    }

    @Test
    fun givenViewDrawer_WhenThereIsFalseVisibility_ThenShouldRenderTrue() {
        // Given
        val key = "KEY"
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
        viewDrawer = ViewDrawer(key, data, null, null)

        // Then
        Assert.assertEquals(ViewDrawer.Type.VISIBILITY_GONE_CARD_VIEW, viewDrawer.type)
    }
}
