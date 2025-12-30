/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.NavigatorRender

interface NavViewData {
    fun toMap(): NavigatorRender
}
