/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [FilterConcertsByCategoryUseCase]
 *
 * @author Yesferal
 */
class FilterConcertsByCategoryUseCaseTest: MockitoTest {

    private val METAL = "METAL"

    lateinit var filterConcertsByCategoryUseCase: FilterConcertsByCategoryUseCase

    private fun getConcerts() = listOf(
        Concert.Builder("1").addTimeInMillis(100).addCategories(listOf(METAL, "ROCK")).build(),
        Concert.Builder("2").addTimeInMillis(90).addCategories(listOf("ROCK")).build(),
        Concert.Builder("3").addTimeInMillis(80).build(),
        Concert.Builder("4").addTimeInMillis(70).addCategories(listOf("JAZZ", METAL)).build(),
        Concert.Builder("5").addTimeInMillis(60).addCategories(listOf(METAL)).build()
    )

    @Test
    fun givenFilter_WhenAllTagsAreRequested_ThenReturnWholeList() {
        // Given
        filterConcertsByCategoryUseCase = FilterConcertsByCategoryUseCase()

        // When
        val filter = CategoryRenderContract.ALL
        val result = filterConcertsByCategoryUseCase.invoke(getConcerts(), filter)

        // Then
        val expected = 5
        Assert.assertEquals(expected, result.size)
    }

    @Test
    fun givenFilter_WhenTagRequestedIsNull_ThenReturnEmptyList() {
        // Given
        filterConcertsByCategoryUseCase = FilterConcertsByCategoryUseCase()

        // When
        val filter: String? = null
        val result = filterConcertsByCategoryUseCase.invoke(getConcerts(), filter)

        // Then
        val expected = 0
        Assert.assertEquals(expected, result.size)
    }

    @Test
    fun givenFilter_WhenATagIsRequested_ThenReturnTheListFiltered() {
        // Given
        filterConcertsByCategoryUseCase = FilterConcertsByCategoryUseCase()

        // When
        val filter = METAL
        val result = filterConcertsByCategoryUseCase.invoke(getConcerts(), filter)

        // Then
        val expected = 3
        Assert.assertEquals(expected, result.size)
        Assert.assertNotEquals(null, result[0].categories)
        Assert.assertEquals(true, result[0].categories!!.contains(METAL))

        Assert.assertNotEquals(null, result[1].categories)
        Assert.assertEquals(true, result[1].categories!!.contains(METAL))

        Assert.assertNotEquals(null, result[2].categories)
        Assert.assertEquals(true, result[2].categories!!.contains(METAL))
    }
}
