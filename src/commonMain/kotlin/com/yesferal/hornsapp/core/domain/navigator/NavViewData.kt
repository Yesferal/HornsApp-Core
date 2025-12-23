/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.NavigatorRenderContract

interface NavViewData {
    fun toMap(): NavigatorRenderContract
}
