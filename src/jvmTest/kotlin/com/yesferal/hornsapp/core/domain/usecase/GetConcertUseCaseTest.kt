/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * This class will test [GetConcertUseCase]
 *
 * @author Yesferal
 */
class GetConcertUseCaseTest: MockitoTest {

    private val concertID = "12345"

    @Mock
    lateinit var concertRepository: ConcertRepository

    private lateinit var getFavoriteConcertsUseCase: GetFavoriteConcertsUseCase

    private lateinit var getConcertUseCase: GetConcertUseCase

    @Before
    override fun mockClasses() {
        getFavoriteConcertsUseCase = GetFavoriteConcertsUseCase(concertRepository)

        runBlocking {
            Mockito.`when`(concertRepository.getConcert(concertID))
                .thenReturn(HaResult.Success(getConcert()))
        }
    }

    private fun getConcert() = Concert.Builder(concertID).build()

    @Test
    fun givenGetConcert_WhenFavorite_ThenReturnFavoriteTrue() {
        runBlocking {
            // Given
            getConcertUseCase = GetConcertUseCase(concertRepository, getFavoriteConcertsUseCase)

            // When
            Mockito.`when`(concertRepository.getFavoriteConcerts())
                .thenReturn(listOf(getConcert()))
            val result = getConcertUseCase.invoke(concertID)

            // Then
            val expected = true
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.isFavorite)
        }
    }

    @Test
    fun givenGetConcert_WhenNotFavorite_ThenReturnFavoriteFalse() {
        runBlocking {
            // Given
            getConcertUseCase = GetConcertUseCase(concertRepository, getFavoriteConcertsUseCase)

            // When
            Mockito.`when`(concertRepository.getFavoriteConcerts())
                .thenReturn(listOf())
            val result = getConcertUseCase.invoke(concertID)

            // Then
            val expected = false
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.isFavorite)
        }
    }
}
