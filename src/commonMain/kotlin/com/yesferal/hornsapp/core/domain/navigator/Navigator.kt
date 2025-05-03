/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.NavigatorRender
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRender

class Navigator private constructor(
    val to: ScreenRender.Type,
    val popBackStackId: Int?,
    val navigatorRender: NavigatorRender?,
) {
    class Builder {
        private var to: ScreenRender.Type = ScreenRender.Type.UNDETERMINED_SCREEN
        private var popBackStackId: Int? = null
        private var navigatorRender: NavigatorRender? = null

        fun to(to: ScreenRender.Type): Builder {
            this.to = to

            return this
        }

        fun to(to: String): Builder {
            try {
                this.to = ScreenRender.Type.valueOf(to)
            } catch (e: Exception) {
                this.to = ScreenRender.Type.UNDETERMINED_SCREEN
            }

            return this
        }

        fun popBackStack(popBackStackId: Int): Builder {
            this.popBackStackId = popBackStackId

            return this
        }

        fun with(navViewData: NavViewData): Builder {
            this.navigatorRender = navViewData.toMap()

            return this
        }

        fun with(navigatorRender: NavigatorRender?): Builder {
            this.navigatorRender = navigatorRender

            return this
        }

        fun build(): Navigator {
            return Navigator(to, popBackStackId, navigatorRender)
        }
    }
}
