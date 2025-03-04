/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.drawer

class DataDrawer(
        val title: LocalizedString?,
        val subtitle: LocalizedString?,
        val description: LocalizedString?,
        val icon: String?,
        val imageUrl: String?,
        val height: Int?,
        val textColor: String?,
        val backgroundColor: String?,
        val visibility: Boolean?
)
