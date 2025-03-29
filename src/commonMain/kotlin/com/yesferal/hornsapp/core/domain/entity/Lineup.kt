package com.yesferal.hornsapp.core.domain.entity

class Lineup(
    val day: String?,
    val stages: List<Stage>?
)

class Stage(
    val title: String?,
    val performances: List<Performance>?
)

class Performance(
    val id: String?,
    val title: String?,
    val subtitle: String?,
    val startTimeInMillis: Long?,
    val duration: Int?
)
