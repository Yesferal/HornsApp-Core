/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract
import com.yesferal.hornsapp.core.domain.util.HaResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * This class will test [GetUpcomingConcertsUseCase]
 *
 * @author Yesferal
 */
class GetUpcomingConcertsUseCaseTest: MockitoTest {

    private val METAL = "METAL"

    @Mock
    lateinit var concertRepository: ConcertRepository

    lateinit var filterConcertsByCategoryUseCase: FilterConcertsByCategoryUseCase

    lateinit var getUpcomingConcertsUseCase: GetUpcomingConcertsUseCase

    @Before
    override fun mockClasses() {
        filterConcertsByCategoryUseCase = FilterConcertsByCategoryUseCase()

        runBlocking {
            Mockito.`when`(concertRepository.getConcerts())
                .thenReturn(HaResult.Success(getConcerts()))
        }
    }

    private fun getConcerts() = listOf(
        Concert.Builder("1").addTimeInMillis(100).addCategories(listOf(METAL, "ROCK")).build(),
        Concert.Builder("2").addTimeInMillis(90).addCategories(listOf("ROCK")).build(),
        Concert.Builder("3").addTimeInMillis(80).build(),
        Concert.Builder("4").addTimeInMillis(70).addCategories(listOf("JAZZ", METAL)).build(),
        Concert.Builder("5").addTimeInMillis(60).addCategories(listOf(METAL)).build()
    )

    @Test
    fun givenGetConcerts_WhenAllTagsAreRequested_ThenReturnWholeList() {
        runBlocking {
            // Given
            getUpcomingConcertsUseCase = GetUpcomingConcertsUseCase(concertRepository, filterConcertsByCategoryUseCase)

            // When
            val filter = CategoryRenderContract.ALL
            val result = getUpcomingConcertsUseCase.invoke(filter)

            // Then
            val expected = 5
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.size)
        }
    }

    @Test
    fun givenGetConcerts_WhenATagIsRequested_ThenReturnTheListFiltered() {
        runBlocking {
            // Given
            getUpcomingConcertsUseCase = GetUpcomingConcertsUseCase(concertRepository, filterConcertsByCategoryUseCase)

            // When
            val filter = METAL
            val result = getUpcomingConcertsUseCase.invoke(filter)

            // Then
            val expected = 3
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.size)

            Assert.assertNotEquals(null, result.value[0].categories)
            Assert.assertEquals(true, result.value[0].categories!!.contains(METAL))

            Assert.assertNotEquals(null, result.value[1].categories)
            Assert.assertEquals(true, result.value[1].categories!!.contains(METAL))

            Assert.assertNotEquals(null, result.value[2].categories)
            Assert.assertEquals(true, result.value[2].categories!!.contains(METAL))
        }
    }

    @Test
    fun givenGetConcerts_WhenAreRequested_ThenReturnSortByTimeInMillis() {
        runBlocking {
            // Given
            getUpcomingConcertsUseCase = GetUpcomingConcertsUseCase(concertRepository, filterConcertsByCategoryUseCase)

            // When
            val filter = CategoryRenderContract.ALL
            val result = getUpcomingConcertsUseCase.invoke(filter)

            // Then
            val expected = 5
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.size)
            Assert.assertEquals(60L, result.value[0].timeInMillis)
            Assert.assertEquals(70L, result.value[1].timeInMillis)
            Assert.assertEquals(80L, result.value[2].timeInMillis)
            Assert.assertEquals(90L, result.value[3].timeInMillis)
            Assert.assertEquals(100L, result.value[4].timeInMillis)
        }
    }
}