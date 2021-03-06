package com.yesferal.hornsapp.core.data.abstraction.storage

import com.yesferal.hornsapp.core.domain.entity.Concert

interface ConcertStorageDataSource {
    suspend fun insertFavoriteConcert(concert: Concert)
    suspend fun removeFavoriteConcert(concert: Concert)
    suspend fun getFavoriteConcerts(): List<Concert>
    fun getConcertCached(): List<Concert>?
    fun updateConcertCached(concerts: List<Concert>?)
}
