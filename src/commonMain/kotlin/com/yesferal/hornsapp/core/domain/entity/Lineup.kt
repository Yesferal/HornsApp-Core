package com.yesferal.hornsapp.core.domain.entity

class Lineup(
    val title: String?,
    val days: List<DailyLineup>?
)

class DailyLineup(
    val dateTimeInMillis: Long?,
    val stages: List<Stage>?
)

class Stage(
    val title: String?,
    val events: List<Event>?
)

class Event(
    val id: String?,
    val title: String?,
    val subtitle: String?,
    val startTimeInMillis: Long?,
    val duration: Int?
)
