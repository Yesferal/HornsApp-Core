/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRender
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
        Concert.Builder("1").addTimeInMillis(100).addTags(listOf(METAL, "ROCK")).build(),
        Concert.Builder("2").addTimeInMillis(90).addTags(listOf("ROCK")).build(),
        Concert.Builder("3").addTimeInMillis(80).build(),
        Concert.Builder("4").addTimeInMillis(70).addTags(listOf("JAZZ", METAL)).build(),
        Concert.Builder("5").addTimeInMillis(60).addTags(listOf(METAL)).build()
    )

    @Test
    fun givenFilter_WhenAllTagsAreRequested_ThenReturnWholeList() {
        // Given
        filterConcertsByCategoryUseCase = FilterConcertsByCategoryUseCase()

        // When
        val filter = CategoryRender.ALL
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
        Assert.assertNotEquals(null, result[0].tags)
        Assert.assertEquals(true, result[0].tags!!.contains(METAL))

        Assert.assertNotEquals(null, result[1].tags)
        Assert.assertEquals(true, result[1].tags!!.contains(METAL))

        Assert.assertNotEquals(null, result[2].tags)
        Assert.assertEquals(true, result[2].tags!!.contains(METAL))
    }
}
