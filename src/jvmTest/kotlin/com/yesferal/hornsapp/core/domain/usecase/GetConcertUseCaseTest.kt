package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetConcertUseCaseTest {

    private val concertID = "12345"

    @Mock
    lateinit var concertRepository: ConcertRepository

    private lateinit var getFavoriteConcertsUseCase: GetFavoriteConcertsUseCase

    private lateinit var getConcertUseCase: GetConcertUseCase

    @Before
    fun init() {
        MockitoAnnotations.openMocks(this)

        getFavoriteConcertsUseCase = GetFavoriteConcertsUseCase(concertRepository)

        runBlocking {
            Mockito.`when`(concertRepository.getConcert(concertID))
                .thenReturn(HaResult.Success(getConcert()))
        }
    }

    private fun getConcert() =
        Concert(concertID, "name", null, null, null, null, false, null, null, null, null, null, null, null)

    @Test
    fun getConcert_whenFavorite_returnFavoriteTrue() {
        runBlocking {
            // Given
            getConcertUseCase = GetConcertUseCase(concertRepository, getFavoriteConcertsUseCase)

            // When
            Mockito.`when`(concertRepository.getFavoriteConcert())
                .thenReturn(listOf(getConcert()))
            val result = getConcertUseCase.invoke(concertID)

            // Then
            val expected = true
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.isFavorite)
        }
    }

    @Test
    fun getConcert_whenNotFavorite_returnFavoriteFalse() {
        runBlocking {
            // Given
            getConcertUseCase = GetConcertUseCase(concertRepository, getFavoriteConcertsUseCase)

            // When
            Mockito.`when`(concertRepository.getFavoriteConcert())
                .thenReturn(listOf())
            val result = getConcertUseCase.invoke(concertID)

            // Then
            val expected = false
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(expected, (result as HaResult.Success).value.isFavorite)
        }
    }
}
