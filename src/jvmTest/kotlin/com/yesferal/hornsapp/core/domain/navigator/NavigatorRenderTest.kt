/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.Venue
import com.yesferal.hornsapp.core.domain.entity.render.NavigatorRender
import org.junit.Assert
import org.junit.Test

class NavigatorRenderTest {

    @Test
    fun given_aParameters_whenItHasString_ThenGetIt() {
        // Given
        val parameters = NavigatorRender()

        // When
        parameters.put("id", "1")

        // Then
        Assert.assertEquals("1", parameters.get("id"))
        Assert.assertEquals("1", parameters.getString("id"))
    }

    @Test
    fun given_aParameters_whenItHasBoolean_ThenGetIt() {
        // Given
        val parameters = NavigatorRender()

        // When
        parameters.put("id", true)

        // Then
        Assert.assertEquals(true, parameters.get("id"))
        Assert.assertEquals(true, parameters.getBoolean("id"))
    }

    @Test
    fun given_aParameters_whenItHasLong_ThenGetIt() {
        // Given
        val parameters = NavigatorRender()

        // When
        parameters.put("id", 1L)

        // Then
        Assert.assertEquals(1L, parameters.get("id"))
        Assert.assertEquals(1L, parameters.getLong("id"))
    }

    @Test
    fun given_aParameters_whenItHasString_ThenGetItAsString() {
        // Given
        val parameters = NavigatorRender()

        // When
        parameters.put("id", "1")

        // Then
        Assert.assertNotEquals(1, parameters.get("id"))
        Assert.assertNotEquals(1, parameters.getString("id"))
    }

    @Test
    fun given_aParameters_whenItHasObject_ThenGetObject() {
        // Given
        val parameters = NavigatorRender()

        // When
        parameters.put("Venue", Venue("id", "name", "description", "mapSearchName", "latitude", "longitude", ""))

        // Then
        Assert.assertEquals(Venue("id", "name", "description", "mapSearchName", "latitude", "longitude", ""), parameters.get("Venue"))
    }
}