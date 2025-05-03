/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedString

class CtaRender(
    val title: LocalizedString?,
    val textColor: String?,
    val backgroundColor: String?,
    val align: String?,
    val navigation: NavigatorRender?,
)
