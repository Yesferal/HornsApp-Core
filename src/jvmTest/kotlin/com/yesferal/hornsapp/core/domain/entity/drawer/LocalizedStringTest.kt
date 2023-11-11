/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.common.Locator
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockedStatic
import org.mockito.Mockito

/**
 * This class will test [LocalizedString]
 *
 * @author Yesferal
 */
class LocalizedStringTest : MockitoTest {

    private lateinit var locator: MockedStatic<Locator>

    private lateinit var localizedString: LocalizedString

    @Before
    override fun mockClasses() {
        locator = Mockito.mockStatic(Locator::class.java)
    }

    @After
    override fun close() {
        locator.close()
    }

    @Test
    fun givenTextDrawer_WhenEnLocator_ThenReturnEnglishCopy() {
        // Given
        localizedString = LocalizedString("englishName", "spanishName")

        // When
        locator.`when`<String> { Locator.language() }.thenReturn("en")

        // Then
        Assert.assertEquals("englishName", localizedString.text)
    }

    @Test
    fun givenTextDrawer_WhenEsLocator_ThenReturnSpanishCopy() {
        // Given
        localizedString = LocalizedString("englishName", "spanishName")

        // When
        locator.`when`<String> { Locator.language() }.thenReturn("es")

        // Then
        Assert.assertEquals("spanishName", localizedString.text)
    }

    @Test
    fun givenTextDrawer_WhenRandomLocator_ThenReturnEnglishCopy() {
        // Given
        localizedString = LocalizedString("englishName", "spanishName")

        // When
        locator.`when`<String> { Locator.language() }.thenReturn("fr")

        // Then
        Assert.assertEquals("englishName", localizedString.text)
    }
}
