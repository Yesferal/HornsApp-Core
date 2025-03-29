package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedString
import com.yesferal.hornsapp.core.domain.navigator.Parameters

class CtaRender(
    val title: LocalizedString?,
    val textColor: String?,
    val backgroundColor: String?,
    val align: String?,
    val navigation: Parameters?,
)
