/* Copyright © 2022 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.navigator

class Navigator private constructor(
    val to: ScreenType,
    val popBackStackId: Int?,
    val parameters: Parameters?,
) {
    class Builder {
        private var to: ScreenType = ScreenType.NONE
        private var popBackStackId: Int? = null
        private var parameters: Parameters? = null

        fun to(to: ScreenType): Builder {
            this.to = to

            return this
        }

        fun to(to: String): Builder {
            try {
                this.to = ScreenType.valueOf(to)
            } catch (e: Exception) {
                this.to = ScreenType.NONE
            }

            return this
        }

        fun popBackStack(popBackStackId: Int): Builder {
            this.popBackStackId = popBackStackId

            return this
        }

        fun with(navViewData: NavViewData): Builder {
            this.parameters = navViewData.toMap()

            return this
        }

        fun with(parameters: Parameters?): Builder {
            this.parameters = parameters

            return this
        }

        fun build(): Navigator {
            return Navigator(to, popBackStackId, parameters)
        }
    }
}
