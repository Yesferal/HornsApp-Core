/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

import com.yesferal.hornsapp.core.domain.entity.render.NavigatorRenderContract
import com.yesferal.hornsapp.core.domain.entity.render.ScreenRenderContract

class Navigator private constructor(
    val to: ScreenRenderContract.Type,
    val popBackStackId: Int?,
    val navigatorRender: NavigatorRenderContract?,
) {
    class Builder {
        private var to: ScreenRenderContract.Type = ScreenRenderContract.Type.UNDETERMINED_SCREEN
        private var popBackStackId: Int? = null
        private var navigatorRender: NavigatorRenderContract? = null

        fun to(to: ScreenRenderContract.Type): Builder {
            this.to = to

            return this
        }

        fun to(to: String): Builder {
            try {
                this.to = ScreenRenderContract.Type.valueOf(to)
            } catch (e: Exception) {
                this.to = ScreenRenderContract.Type.UNDETERMINED_SCREEN
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

        fun with(navigatorRender: NavigatorRenderContract?): Builder {
            this.navigatorRender = navigatorRender

            return this
        }

        fun build(): Navigator {
            return Navigator(to, popBackStackId, navigatorRender)
        }
    }
}
