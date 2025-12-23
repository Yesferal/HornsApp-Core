/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.entity.render

import com.yesferal.hornsapp.core.domain.entity.util.LocalizedStringContract

interface DataRenderContract {
        val title: LocalizedStringContract?
        val subtitle: LocalizedStringContract?
        val description: LocalizedStringContract?
        val icon: String?
        val imageUrl: String?
        val ctas: List<CtaRenderContract>?
}

data class DataRender(
        override val title: LocalizedStringContract?,
        override val subtitle: LocalizedStringContract?,
        override val description: LocalizedStringContract?,
        override val icon: String?,
        override val imageUrl: String?,
        override val ctas: List<CtaRenderContract>?
) : DataRenderContract
