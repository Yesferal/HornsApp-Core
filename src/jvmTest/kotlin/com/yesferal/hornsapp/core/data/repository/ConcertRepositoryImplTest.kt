package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.MockitoTest
import com.yesferal.hornsapp.core.data.abstraction.remote.ConcertRemoteDataSource
import com.yesferal.hornsapp.core.data.abstraction.storage.ConcertStorageDataSource
import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.util.HaResult
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

/**
 * This class will test [ConcertRepositoryImpl]
 *
 * @author Yesferal
 * Copyright © 2021 HornsApp. All rights reserved.
 */
class ConcertRepositoryImplTest: MockitoTest {

    lateinit var concertRepositoryImpl: ConcertRepositoryImpl

    @Mock
    lateinit var concertStorageDataSource: ConcertStorageDataSource

    @Mock
    lateinit var concertRemoteDataSource: ConcertRemoteDataSource

    private val concerts = listOf(Concert.Builder("12345").build())

    @Before
    override fun mockClasses() {
        runBlocking {
            Mockito.`when`(concertStorageDataSource.getConcertCached())
                .thenReturn(null)
            Mockito.`when`(concertRemoteDataSource.getConcerts())
                .thenReturn(HaResult.Success(concerts))
        }
    }

    @Test
    fun givenGetConcertsAreNotCached_WhenRemoteSuccess_ThenReturnSuccess() {
        runBlocking {
            // Given
            concertRepositoryImpl = ConcertRepositoryImpl(concertStorageDataSource, concertRemoteDataSource)

            // When
            val result = concertRepositoryImpl.getConcerts()

            // Then
            verify(concertStorageDataSource, times(1)).getConcertCached()
            verify(concertRemoteDataSource, times(1)).getConcerts()
            verify(concertStorageDataSource, times(1)).updateConcertCached(concerts)
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(concerts, (result as HaResult.Success).value)
        }
    }

    @Test
    fun givenGetConcertsAreNotCached_WhenRemoteFailed_ThenReturnFail() {
        runBlocking {
            // Given
            concertRepositoryImpl = ConcertRepositoryImpl(concertStorageDataSource, concertRemoteDataSource)

            // When
            Mockito.`when`(concertRemoteDataSource.getConcerts())
                .thenReturn(HaResult.Error)
            val result = concertRepositoryImpl.getConcerts()

            // Then
            verify(concertStorageDataSource, times(1)).getConcertCached()
            verify(concertRemoteDataSource, times(1)).getConcerts()
            verify(concertStorageDataSource, times(0)).updateConcertCached(concerts)
            Assert.assertEquals(true, result is HaResult.Error)
        }
    }

    @Test
    fun givenGetConcerts_WhenAreCached_ThenUseStorageDataSource() {
        runBlocking {
            // Given
            concertRepositoryImpl = ConcertRepositoryImpl(concertStorageDataSource, concertRemoteDataSource)

            // When
            Mockito.`when`(concertStorageDataSource.getConcertCached())
                .thenReturn(concerts)
            val result = concertRepositoryImpl.getConcerts()

            // Then
            verify(concertStorageDataSource, times(1)).getConcertCached()
            verify(concertRemoteDataSource, times(0)).getConcerts()
            verify(concertStorageDataSource, times(0)).updateConcertCached(concerts)
            Assert.assertEquals(true, result is HaResult.Success)
            Assert.assertEquals(concerts, (result as HaResult.Success).value)
        }
    }
}
