/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.Concert

data class ChildrenRender(
    val key: String?,
    val filter: FilterRender?,
    val sort: List<String>?,
    val take: Int?,
){
    enum class Type {
        CAROUSEL_CARD_VIEW,
        UPCOMING_CARD_VIEW,
        UPCOMING_IMAGE_CARD_VIEW,
        UNDETERMINED
    }

    val type: Type
        get() = when (key) {
            Type.CAROUSEL_CARD_VIEW.name -> Type.CAROUSEL_CARD_VIEW
            Type.UPCOMING_CARD_VIEW.name -> Type.UPCOMING_CARD_VIEW
            Type.UPCOMING_IMAGE_CARD_VIEW.name -> Type.UPCOMING_IMAGE_CARD_VIEW
            else -> Type.UNDETERMINED
        }


    fun getConcertsForSections(
        concerts: List<Concert>,
    ): List<Concert> {
        // Children On Demand
        // FIXME: We can rename sort as onDemand or something similar
        // due to we pick concerts on demand following the ViewRender model
        val children = concerts
            .filter { this.sort?.contains(it.id) == true }

        return children.ifEmpty {
            filterConcertsBySectionDataSource(
                when (this.type) {
                    Type.CAROUSEL_CARD_VIEW -> {
                        concerts.reversed()
                    }

                    Type.UPCOMING_CARD_VIEW, Type.UPCOMING_IMAGE_CARD_VIEW -> {
                        concerts.sortedWith(compareBy { it.timeInMillis })
                    }

                    else -> listOf()
                }
            )
        }
    }

    private fun filterConcertsBySectionDataSource(
        concerts: List<Concert>,
    ): List<Concert> {
        var events = concerts
            .filter { concert ->
                val events = this.filter?.events
                if (events.isNullOrEmpty()) {
                    true
                } else {
                    events.contains(concert.id)
                }
            }

        if (events.isEmpty()) {
            events = concerts
        }

        return events.filter { concert ->
            val categories = this.filter?.categories
            if (categories.isNullOrEmpty()) {
                true
            } else {
                categories.any { anyCategory ->
                    concert.categories?.contains(anyCategory) == true
                }
            }
        }.take(this.take ?: Int.MAX_VALUE)
    }
}

data class FilterRender(
    val events: List<String>?,
    val categories: List<String>?
)
