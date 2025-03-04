/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

data class ConditionDrawer(
    private val key: String?,
    val defaultValues: List<String>?,
    val filterBy: String?,
    val count: Int?,
){
    enum class Type {
        SORT_BY_NEWEST_DATE,
        SORT_BY_UPCOMING_DATE,
        FILTER_BY_CATEGORY,
        PICK_FROM_DEFAULT_VALUES,
        UNDETERMINED
    }

    val type: Type
        get() = when (key) {
            Type.SORT_BY_NEWEST_DATE.name -> Type.SORT_BY_NEWEST_DATE
            Type.SORT_BY_UPCOMING_DATE.name -> Type.SORT_BY_UPCOMING_DATE
            Type.FILTER_BY_CATEGORY.name -> Type.FILTER_BY_CATEGORY
            Type.PICK_FROM_DEFAULT_VALUES.name -> Type.PICK_FROM_DEFAULT_VALUES
            else -> Type.UNDETERMINED
        }
}
