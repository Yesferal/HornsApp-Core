/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedString

class DataRender(
        val key: String?,
        val title: LocalizedString?,
        val subtitle: LocalizedString?,
        val description: LocalizedString?,
        val icon: String?,
        val imageUrl: String?,
        val width: Int?,
        val height: Int?,
        val textColor: String?,
        val backgroundColor: String?,
        val elevation: Boolean?,
        val ctas: List<CtaRender>?,
        val visibility: Boolean?,
)
