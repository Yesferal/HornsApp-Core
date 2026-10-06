/* Copyright © 2026 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.entity.Concert
import org.junit.Assert
import org.junit.Test

/**
 * This class will test [GetRelatedConcertsUseCase]
 *
 * @author Yesferal
 */
class GetRelatedConcertsUseCaseTest : MockitoTest {

    private val METAL = "METAL"
    private val ROCK = "ROCK"
    private val JAZZ = "JAZZ"

    private lateinit var getRelatedConcertsUseCase: GetRelatedConcertsUseCase

    private fun getConcerts() = listOf(
        Concert.Builder("1").addTimeInMillis(100).addCategories(listOf(METAL, ROCK)).build(),
        Concert.Builder("2").addTimeInMillis(90).addCategories(listOf(ROCK)).build(),
        Concert.Builder("3").addTimeInMillis(80).build(),
        Concert.Builder("4").addTimeInMillis(70).addCategories(listOf(JAZZ, METAL)).build(),
        Concert.Builder("5").addTimeInMillis(60).addCategories(listOf(METAL)).build(),
        Concert.Builder("6").addTimeInMillis(50).addCategories(listOf(JAZZ)).build(),
    )

    @Test
    fun givenCurrentWithCategories_WhenRelatedRequested_ThenReturnSharedCategoryConcertsExcludingSelf() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = getConcerts().first { it.id == "1" }

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current)

        // Then — shares METAL or ROCK with #1 → #2 (ROCK), #4 (METAL), #5 (METAL); sorted by date
        Assert.assertEquals(listOf("5", "4", "2"), result.map { it.id })
    }

    @Test
    fun givenCurrentWithNoCategories_WhenRelatedRequested_ThenReturnEmptyList() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = getConcerts().first { it.id == "3" }

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current)

        // Then
        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun givenCurrentWithUniqueCategory_WhenRelatedRequested_ThenReturnEmptyList() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = Concert.Builder("99")
            .addTimeInMillis(10)
            .addCategories(listOf("FOLK"))
            .build()

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current)

        // Then
        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun givenRelated_WhenTakeIsLimited_ThenReturnAtMostTakeItems() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = getConcerts().first { it.id == "1" }

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current, take = 2)

        // Then — earliest two by date among related
        Assert.assertEquals(listOf("5", "4"), result.map { it.id })
    }

    @Test
    fun givenRelated_WhenTakeIsZero_ThenReturnEmptyList() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = getConcerts().first { it.id == "1" }

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current, take = 0)

        // Then
        Assert.assertTrue(result.isEmpty())
    }

    @Test
    fun givenCurrentWithJazz_WhenRelatedRequested_ThenExcludeSelfAndIncludeJazzPeers() {
        // Given
        getRelatedConcertsUseCase = GetRelatedConcertsUseCase()
        val current = getConcerts().first { it.id == "4" }

        // When
        val result = getRelatedConcertsUseCase.invoke(getConcerts(), current)

        // Then — #4 has JAZZ+METAL → #1 (METAL), #5 (METAL), #6 (JAZZ); exclude #4
        Assert.assertEquals(listOf("6", "5", "1"), result.map { it.id })
        Assert.assertFalse(result.any { it.id == "4" })
    }
}
