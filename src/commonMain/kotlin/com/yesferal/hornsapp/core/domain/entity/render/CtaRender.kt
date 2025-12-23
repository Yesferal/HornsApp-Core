/* Copyright © 2025 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedStringContract

interface CtaRenderContract {
    val title: LocalizedStringContract?
    val textColor: String?
    val backgroundColor: String?
    val align: String?
    val navigation: NavigatorRenderContract?
}

data class CtaRender(
    override val title: LocalizedStringContract?,
    override val textColor: String?,
    override val backgroundColor: String?,
    override val align: String?,
    override val navigation: NavigatorRenderContract?
) : CtaRenderContract
