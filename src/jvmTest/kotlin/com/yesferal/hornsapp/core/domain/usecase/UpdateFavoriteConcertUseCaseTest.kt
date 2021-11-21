package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.core.domain.entity.Concert
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

/**
 * This class will test [UpdateFavoriteConcertUseCase]
 *
 * @author Yesferal
 * Copyright © 2021 HornsApp. All rights reserved.
 */
class UpdateFavoriteConcertUseCaseTest: MockitoTest {

    private val concertID = "12345"

    @Mock
    lateinit var concertRepository: ConcertRepository

    private lateinit var updateFavoriteConcertUseCase: UpdateFavoriteConcertUseCase

    private val concert = Concert.Builder(concertID).build()

    @Test
    fun givenUpdateFavoriteConcert_WhenFavorite_ThenInsertIt() {
        runBlocking {
            // Given
            updateFavoriteConcertUseCase = UpdateFavoriteConcertUseCase(concertRepository)

            // When
            updateFavoriteConcertUseCase.invoke(concert, true)

            // Then
            verify(concertRepository, times(1)).insertFavoriteConcert(concert)
        }
    }

    @Test
    fun givenUpdateFavoriteConcert_WhenNotFavorite_ThenRemoveIt() {
        runBlocking {
            // Given
            updateFavoriteConcertUseCase = UpdateFavoriteConcertUseCase(concertRepository)

            // When
            updateFavoriteConcertUseCase.invoke(concert, false)

            // Then
            verify(concertRepository, times(1)).removeFavoriteConcert(concert)
        }
    }
}
