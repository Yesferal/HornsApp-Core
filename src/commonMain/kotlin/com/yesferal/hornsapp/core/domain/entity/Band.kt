package com.yesferal.hornsapp.core.domain.entity

data class Band (
    val id: String,
    val name: String?,
    val about: String?,
    val logoImage: String?,
    val membersImage: String?,
    val country: String?,
    val formerIn: Int?,
    val genres: List<String>?,
)
