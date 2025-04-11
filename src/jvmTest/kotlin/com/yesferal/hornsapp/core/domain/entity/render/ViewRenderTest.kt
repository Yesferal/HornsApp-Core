/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.MockitoTest
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [ViewRender]
 *
 * @author Yesferal
 */
class ViewRenderTest : MockitoTest {

    private lateinit var viewRender: ViewRender

    @Test
    fun givenViewRender_WhenThereIsNotData_ThenShouldRenderTrue() {
        // Given
        val key = ViewRender.Type.CARD_VIEW
        val data = null

        // When
        viewRender = ViewRender(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewRender.type)
    }

    @Test
    fun givenViewRender_WhenThereIsNotVisibility_ThenShouldRenderTrue() {
        // Given
        val key = ViewRender.Type.CARD_VIEW
        val data = DataRender(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = null,
            backgroundColor = null,
            elevation = null,
            ctas = null,
        )

        // When
        viewRender = ViewRender(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewRender.type)
    }

    @Test
    fun givenViewRender_WhenThereIsTrueVisibility_ThenShouldRenderTrue() {
        // Given
        val key = ViewRender.Type.CARD_VIEW
        val data = DataRender(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = true,
            backgroundColor = null,
            elevation = null,
            ctas = null,
        )

        // When
        viewRender = ViewRender(key.name, data, null, null)

        // Then
        Assert.assertEquals(key, viewRender.type)
    }

    @Test
    fun givenViewRender_WhenThereIsFalseVisibility_ThenShouldRenderTrue() {
        // Given
        val key = ViewRender.Type.CARD_VIEW
        val data = DataRender(
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            visibility = false,
            backgroundColor = null,
            elevation = null,
            ctas = null,
        )

        // When
        viewRender = ViewRender(key.name, data, null, null)

        // Then
        Assert.assertEquals(ViewRender.Type.VISIBILITY_GONE_CARD_VIEW, viewRender.type)
    }
}
