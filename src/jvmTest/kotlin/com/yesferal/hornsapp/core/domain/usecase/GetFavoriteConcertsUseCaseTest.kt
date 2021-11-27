/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * This class will test [GetFavoriteConcertsUseCase]
 *
 * @author Yesferal
 */
class GetFavoriteConcertsUseCaseTest: MockitoTest {

    @Mock
    lateinit var concertRepository: ConcertRepository

    lateinit var getFavoriteConcertsUseCase: GetFavoriteConcertsUseCase

    @Before
    override fun mockClasses() {
        runBlocking {
            Mockito.`when`(concertRepository.getFavoriteConcerts())
                .thenReturn(getConcerts())
        }
    }

    private fun getConcerts() = listOf(
        Concert.Builder("1").addTimeInMillis(100).build(),
        Concert.Builder("2").addTimeInMillis(90).build(),
        Concert.Builder("3").addTimeInMillis(80).build(),
        Concert.Builder("4").addTimeInMillis(70).build(),
        Concert.Builder("5").addTimeInMillis(60).build()
    )

    @Test
    fun givenGetConcerts_WhenAreRequested_ThenReturnSortByTimeInMillis() {
        runBlocking {
            // Given
            getFavoriteConcertsUseCase = GetFavoriteConcertsUseCase(concertRepository)

            // When
            val result = getFavoriteConcertsUseCase.invoke()

            // Then
            val expected = 5
            Assert.assertEquals(expected, result.size)
            Assert.assertEquals(60L, result[0].timeInMillis)
            Assert.assertEquals(70L, result[1].timeInMillis)
            Assert.assertEquals(80L, result[2].timeInMillis)
            Assert.assertEquals(90L, result[3].timeInMillis)
            Assert.assertEquals(100L, result[4].timeInMillis)
        }
    }
}
