package com.yesferal.hornsapp.core.domain.entity

data class Concert (
    val id: String,
    val name: String?,
    val headlinerImage: String?,
    val timeInMillis: Long?,
    val genre: String?,
    val tags: List<String>?,
    var isFavorite: Boolean,
    val description: String? = null,
    val trailerUrl: String? = null,
    val facebookUrl: String? = null,
    val venue: Venue? = null,
    val bands: List<Band>? = null,
    val ticketingUrl: String? = null,
    val ticketingHost: String? = null
)
