package com.yesferal.hornsapp.core.domain.entity

import com.yesferal.hornsapp.core.domain.common.HaDate
import com.yesferal.hornsapp.core.domain.util.SafeUri

data class Concert (
    val id: String,
    val name: String?,
    val headlinerImage: String?,
    val dateTime: HaDate?,
    val genre: String?,
    val tags: List<String>?,
    var isFavorite: Boolean,
    val description: String? = null,
    val trailerUrl: SafeUri? = null,
    val facebookUrl: SafeUri? = null,
    val venue: Venue? = null,
    val bands: List<Band>? = null,
    val ticketingUrl: SafeUri? = null,
    val ticketingHost: String? = null
)
